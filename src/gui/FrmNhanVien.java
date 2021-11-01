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
		JLabel lblTieuDe = new JLabel("Thêm Thông Tin Nhân Viên");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblTieuDe.setBounds(197, 0, 495, 47);
		contentPane.add(lblTieuDe);
		
		JPanel pnlTrai = new JPanel();
		pnlTrai.setBackground(new Color(211, 211, 211));
		pnlTrai.setBounds(10, 58, 512, 464);
		contentPane.add(pnlTrai);
		pnlTrai.setLayout(null);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaNV.setForeground(new Color(0, 0, 0));
		lblMaNV.setBounds(20, 10, 127, 25);
		pnlTrai.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaNV.setBounds(176, 10, 303, 30);
		pnlTrai.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenNV.setBounds(20, 50, 144, 24);
		pnlTrai.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTenNV.setBounds(176, 49, 303, 30);
		pnlTrai.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgaySinh.setBounds(20, 89, 127, 24);
		pnlTrai.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtNgaySinh.setBounds(176, 89, 303, 30);
		pnlTrai.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGioiTinh.setBounds(20, 130, 127, 25);
		pnlTrai.add(lblGioiTinh);
		
		radNam = new JRadioButton("Nam");
		radNam.setSelected(true);
		radNam.setFont(new Font("Times New Roman", Font.BOLD, 20));
		radNam.setBounds(176, 130, 77, 21);
		pnlTrai.add(radNam);
		
		radNu = new JRadioButton("Nữ");
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
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblChucVu.setBounds(20, 219, 127, 24);
		pnlTrai.add(lblChucVu);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDiaChi.setBounds(20, 263, 127, 24);
		pnlTrai.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDiaChi.setBounds(176, 266, 303, 30);
		pnlTrai.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblSDT = new JLabel("Số điện thoại:");
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
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLuu.setBounds(164, 418, 113, 36);
		pnlTrai.add(btnLuu);
		
		cmbChucVu = new JComboBox<String>();
		cmbChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbChucVu.addItem("Quản lí");
		cmbChucVu.addItem("Nhân viên bán hàng");
		cmbChucVu.addItem("Quản lí cấp cao");
		cmbChucVu.setBounds(176, 216, 303, 30);
		pnlTrai.add(cmbChucVu);
		
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXoaTrang.setBounds(309, 418, 144, 36);
		pnlTrai.add(btnXoaTrang);
		
		Panel pnlPhai = new Panel();
		pnlPhai.setBackground(new Color(211, 211, 211));
		pnlPhai.setBounds(550, 58, 308, 464);
		contentPane.add(pnlPhai);
		pnlPhai.setLayout(null);
		
		btnChonHinh = new JButton("Chọn hình");
		btnChonHinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnChonHinh.setBounds(78, 351, 157, 41);
		pnlPhai.add(btnChonHinh);
		
		lblHinh = new JLabel();
		lblHinh.setBounds(55, 51, 200, 250);
		pnlPhai.add(lblHinh);
		
		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuayLai.setBounds(550, 540, 158, 33);
		contentPane.add(btnQuayLai);
		
		btnThoat = new JButton("Thoát");
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
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn kết thúc?", "Thông Báo",
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
				JOptionPane.showMessageDialog(this, "Đã lưu!");
			else
				JOptionPane.showMessageDialog(this, "Không lưu được!");
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
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhân viên!");
			txtMaNV.selectAll();
			txtMaNV.requestFocus();
			return false;
		}
		else {
			if(chucVu.equals("Quản lí")) {
				if(!(maNV.matches("NVQL[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên nhập theo mẫu NVQLXXX (X:số bất kì), VD: NVQL123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
			if(chucVu.equals("Nhân viên bán hàng")) {
				if(!(maNV.matches("NVBH[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên nhập theo mẫu NVBHXXX (X:số bất kì), VD: NVBH123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
			if(chucVu.equals("Quản lí cấp cao")) {
				if(!(maNV.matches("QLCC[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this, "Mã nhân viên nhập theo mẫu QLCCXXX (X:số bất kì), VD: QLCC123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
		}
		
		if(!(tenNV.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên nhân viên!");
			txtTenNV.selectAll();
			txtTenNV.requestFocus();
			return false;
		}
				
		try {
			LocalDate ngaySinh=LocalDate.parse(txtNgaySinh.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ngày sinh nhập theo định dạng yyyy-mm-dd, VD: 1990-03-20");
			txtNgaySinh.selectAll();
			txtNgaySinh.requestFocus();
			return false;
		}
		
		if(!(cmnd.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số CMND/CCCD!");
			txtCMND.selectAll();
			txtCMND.requestFocus();
			return false;
		}
		else {
			if(!(cmnd.matches("[0-9]{9,12}"))) {
				JOptionPane.showMessageDialog(this, "Số CMND/CCCD phải nhập đầy đủ từ 9 đến 12 số!");
				txtCMND.selectAll();
				txtCMND.requestFocus();
				return false;
			}
		}
		
		if(!(diaChi.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ!");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		}
		
		if(!(sdt.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại!");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		else {
			if(!(sdt.matches("[0-9]{10}"))) {
				JOptionPane.showMessageDialog(this, "Số điện thoại phải nhập đầy đủ 10 số!");
				txtSDT.selectAll();
				txtSDT.requestFocus();
				return false;
			}
		}
		
		if(!(email.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập email!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		
		if(dir==null) {
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn hình!");
			return false;
		}
		else {
			if(!(dir.matches(".*(.png|.jpg|.gif)|(.PNG|.JPG|.GIF)$"))) {
				JOptionPane.showMessageDialog(this, "Hình phải là png, jpg, gif!");
				return false;
			}
		}
		return true;
	}
}