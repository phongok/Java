package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Panel;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class FrmNhanVien extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtNgaySinh;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JComboBox<String> cmbChucVu;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JLabel lblHinh;
	private JFileChooser fch;
	private File file;
	private String dir;
	private JButton btnChonHinh;
	private JButton btnLuu;
	private NhanVien_DAO nvDao;
	private TaiKhoan_DAO tkDao;
	private JButton btnThoat;
	private JButton btnQuayLai;
	private JButton btnXoaTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanVien frame = new FrmNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmNhanVien() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(300, 50, 882, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nvDao=new NhanVien_DAO();
		tkDao = new TaiKhoan_DAO();
		JLabel lblTieuDe = new JLabel("Th??m Th??ng Tin Nh??n Vi??n");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblTieuDe.setBounds(197, 0, 495, 47);
		contentPane.add(lblTieuDe);
		
		JPanel pnlTrai = new JPanel();
		pnlTrai.setBackground(new Color(211, 211, 211));
		pnlTrai.setBounds(10, 58, 512, 464);
		contentPane.add(pnlTrai);
		pnlTrai.setLayout(null);
		
		JLabel lblMaNV = new JLabel("M?? nh??n vi??n:");
		lblMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaNV.setForeground(new Color(0, 0, 0));
		lblMaNV.setBounds(20, 10, 127, 25);
		pnlTrai.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaNV.setBounds(176, 10, 303, 30);
		pnlTrai.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTenNV = new JLabel("T??n nh??n vi??n:");
		lblTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenNV.setBounds(20, 50, 144, 24);
		pnlTrai.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTenNV.setBounds(176, 49, 303, 30);
		pnlTrai.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ng??y sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgaySinh.setBounds(20, 89, 127, 24);
		pnlTrai.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtNgaySinh.setBounds(176, 89, 303, 30);
		pnlTrai.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Gi???i t??nh:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGioiTinh.setBounds(20, 130, 127, 25);
		pnlTrai.add(lblGioiTinh);
		
		radNam = new JRadioButton("Nam");
		radNam.setSelected(true);
		radNam.setFont(new Font("Times New Roman", Font.BOLD, 20));
		radNam.setBounds(176, 130, 77, 21);
		pnlTrai.add(radNam);
		
		radNu = new JRadioButton("N???");
		radNu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		radNu.setBounds(286, 130, 67, 21);
		pnlTrai.add(radNu);
		
		ButtonGroup btnGroup=new ButtonGroup();
		btnGroup.add(radNam);
		btnGroup.add(radNu);
		
		JLabel lblCMND = new JLabel("CMND/CCCD:");
		lblCMND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCMND.setBounds(20, 176, 138, 24);
		pnlTrai.add(lblCMND);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCMND.setBounds(176, 176, 303, 30);
		pnlTrai.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblChucVu = new JLabel("Ch???c v???:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblChucVu.setBounds(20, 219, 127, 24);
		pnlTrai.add(lblChucVu);
		
		JLabel lblDiaChi = new JLabel("?????a ch???:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDiaChi.setBounds(20, 263, 127, 24);
		pnlTrai.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDiaChi.setBounds(176, 266, 303, 30);
		pnlTrai.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblSDT = new JLabel("S??? ??i???n tho???i:");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSDT.setBounds(20, 314, 127, 24);
		pnlTrai.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSDT.setBounds(176, 311, 303, 30);
		pnlTrai.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(20, 365, 127, 24);
		pnlTrai.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtEmail.setBounds(176, 365, 303, 30);
		pnlTrai.add(txtEmail);
		txtEmail.setColumns(10);
		
		btnLuu = new JButton("L??u");
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLuu.setBounds(164, 418, 113, 36);
		pnlTrai.add(btnLuu);
		
		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbChucVu.addItem("Qu???n l??");
		cmbChucVu.addItem("Nh??n vi??n b??n h??ng");
		cmbChucVu.addItem("Qu???n l?? c???p cao");
		cmbChucVu.setBounds(176, 216, 303, 30);
		pnlTrai.add(cmbChucVu);
		
		btnXoaTrang = new JButton("X??a Tr???ng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXoaTrang.setBounds(309, 418, 144, 36);
		pnlTrai.add(btnXoaTrang);
		
		Panel pnlPhai = new Panel();
		pnlPhai.setBackground(new Color(211, 211, 211));
		pnlPhai.setBounds(550, 58, 308, 464);
		contentPane.add(pnlPhai);
		pnlPhai.setLayout(null);
		
		btnChonHinh = new JButton("Ch???n h??nh");
		btnChonHinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnChonHinh.setBounds(78, 351, 157, 41);
		pnlPhai.add(btnChonHinh);
		
		lblHinh = new JLabel();
		lblHinh.setBounds(55, 51, 200, 250);
		pnlPhai.add(lblHinh);
		
		btnQuayLai = new JButton("Quay L???i");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuayLai.setBounds(550, 540, 158, 33);
		contentPane.add(btnQuayLai);
		
		btnThoat = new JButton("Tho??t");
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThoat.setBounds(732, 540, 110, 33);
		contentPane.add(btnThoat);
		
		btnLuu.addActionListener(this);
		btnChonHinh.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnThoat.addActionListener(this);
		Database.getInstance().connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src=e.getSource();
		if(src.equals(btnLuu))
			luu();
		else if(src.equals(btnChonHinh))
			themHinh();
		
		else if(src.equals(btnThoat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n k???t th??c?", "Th??ng B??o",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		else if (src.equals(btnQuayLai)) {
			dispose();
			new FrmIndex(FrmDangNhap.getIdn()).setVisible(true);
		}
	}
	
	private void themHinh() {
		fch= new JFileChooser("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\IMGNhanVien");
		int state = fch.showOpenDialog(this);
		if(state==JFileChooser.APPROVE_OPTION) {
			file= fch.getSelectedFile();
			dir=file.getAbsolutePath();
			lblHinh.setIcon(new ImageIcon(dir));
		}
	}
	
	private void luu() {
		if(validData()) {
			String maNV=txtMaNV.getText();
			String tenNV=txtTenNV.getText();
			LocalDate ngaySinh=LocalDate.parse(txtNgaySinh.getText());
			boolean gioiTinh=radNam.isSelected();
			String cmnd=txtCMND.getText();
			String chucVu=cmbChucVu.getSelectedItem().toString();
			String diaChi=txtDiaChi.getText();
			String sdt=txtSDT.getText();
			String email=txtEmail.getText();
			String mtkhau = "12345";
			NhanVien nv=new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, cmnd, chucVu, dir, diaChi, sdt, email);
			TaiKhoan tk = new TaiKhoan(new NhanVien(maNV), cmnd, chucVu, mtkhau);
			if(nvDao.luu(nv) && tkDao.create(tk))
				JOptionPane.showMessageDialog(this, "???? l??u!");
			else
				JOptionPane.showMessageDialog(this, "Kh??ng l??u ???????c!");
		}
	}
	
	private boolean validData() {
		String maNV=txtMaNV.getText();
		String tenNV=txtTenNV.getText();
		String cmnd=txtCMND.getText();
		String chucVu=cmbChucVu.getSelectedItem().toString();
		String diaChi=txtDiaChi.getText();
		String sdt=txtSDT.getText();
		String email=txtEmail.getText();
		
		if(!(maNV.length()>0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p m?? nh??n vi??n!");
			txtMaNV.selectAll();
			txtMaNV.requestFocus();
			return false;
		}
		else {
			if(chucVu.equals("Qu???n l??")) {
				if(!(maNV.matches("NVQL[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this, "M?? nh??n vi??n nh???p theo m???u NVQLXXX (X:s??? b???t k??), VD: NVQL123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
			if(chucVu.equals("Nh??n vi??n b??n h??ng")) {
				if(!(maNV.matches("NVBH[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this, "M?? nh??n vi??n nh???p theo m???u NVBHXXX (X:s??? b???t k??), VD: NVBH123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
			if(chucVu.equals("Qu???n l?? c???p cao")) {
				if(!(maNV.matches("QLCC[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this, "M?? nh??n vi??n nh???p theo m???u QLCCXXX (X:s??? b???t k??), VD: QLCC123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
		}
		
		if(!(tenNV.length()>0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p t??n nh??n vi??n!");
			txtTenNV.selectAll();
			txtTenNV.requestFocus();
			return false;
		}
				
		try {
			LocalDate ngaySinh=LocalDate.parse(txtNgaySinh.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ng??y sinh nh???p theo ?????nh d???ng yyyy-mm-dd, VD: 1990-03-20");
			txtNgaySinh.selectAll();
			txtNgaySinh.requestFocus();
			return false;
		}
		
		if(!(cmnd.length()>0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p s??? CMND/CCCD!");
			txtCMND.selectAll();
			txtCMND.requestFocus();
			return false;
		}
		else {
			if(!(cmnd.matches("[0-9]{9,12}"))) {
				JOptionPane.showMessageDialog(this, "S??? CMND/CCCD ph???i nh???p ?????y ????? t??? 9 ?????n 12 s???!");
				txtCMND.selectAll();
				txtCMND.requestFocus();
				return false;
			}
		}
		
		if(!(diaChi.length()>0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p ?????a ch???!");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		}
		
		if(!(sdt.length()>0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p s??? ??i???n tho???i!");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		else {
			if(!(sdt.matches("[0-9]{10}"))) {
				JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i ph???i nh???p ?????y ????? 10 s???!");
				txtSDT.selectAll();
				txtSDT.requestFocus();
				return false;
			}
		}
		
		if(!(email.length()>0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p email!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		
		if(dir==null) {
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n h??nh!");
			return false;
		}
		else {
			if(!(dir.matches(".*(.png|.jpg|.gif)|(.PNG|.JPG|.GIF)$"))) {
				JOptionPane.showMessageDialog(this, "H??nh ph???i l?? png, jpg, gif!");
				return false;
			}
		}
		return true;
	}
}