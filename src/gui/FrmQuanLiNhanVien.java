package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.Database;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.ChucVu;
import entity.KhachHang;
import entity.NhanVien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class FrmQuanLiNhanVien extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtTimMa;
	private JTextField txtTimCMND;
	private JTextField txtTimSDT;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtNgaySinh;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JLabel lblHinh;
	private String dir;
	private JFileChooser fch;
	private File file;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JComboBox<String> cmbChucVu;
	private JTable tbl;
	private DefaultTableModel dataModel;
	private JButton btnChonHinh;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private NhanVien_DAO nvDao;
	private TaiKhoan_DAO tkDao;
	private JButton btnThoat;
	private JButton btnQuayLai;
	private JButton btnTimMa;
	private JButton btnTimCMND;
	private JButton btnTimSDT;
	private JButton btnHienBang;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLiNhanVien frame = new FrmQuanLiNhanVien();
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
	public FrmQuanLiNhanVien() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(10, 20, 1488, 788);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		nvDao = new NhanVien_DAO();
		tkDao = new TaiKhoan_DAO();
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.PINK);
		panelTop.setBounds(10, 10, 1466, 458);
		contentPane.add(panelTop);
		panelTop.setLayout(null);

		JPanel pnlTim = new JPanel();
		pnlTim.setBackground(Color.LIGHT_GRAY);
		pnlTim.setBounds(926, 35, 512, 411);
		panelTop.add(pnlTim);
		pnlTim.setLayout(null);

		JLabel lblTimMa = new JLabel("T??m theo m??:");
		lblTimMa.setBounds(10, 21, 124, 24);
		lblTimMa.setForeground(Color.BLACK);
		lblTimMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlTim.add(lblTimMa);

		JLabel lblTimTen = new JLabel("T??m theo CMND:");
		lblTimTen.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTimTen.setBounds(10, 104, 154, 24);
		pnlTim.add(lblTimTen);

		JLabel lblTimSDT = new JLabel("T??m theo SDT:");
		lblTimSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTimSDT.setBounds(10, 184, 127, 24);
		pnlTim.add(lblTimSDT);

		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTimMa.setColumns(10);
		txtTimMa.setBounds(176, 18, 303, 30);
		pnlTim.add(txtTimMa);

		txtTimCMND = new JTextField();
		txtTimCMND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTimCMND.setColumns(10);
		txtTimCMND.setBounds(176, 101, 303, 30);
		pnlTim.add(txtTimCMND);

		txtTimSDT = new JTextField();
		txtTimSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTimSDT.setColumns(10);
		txtTimSDT.setBounds(176, 181, 303, 30);
		pnlTim.add(txtTimSDT);

		btnCapNhat = new JButton("C???p nh???t");
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCapNhat.setBounds(221, 309, 124, 30);
		pnlTim.add(btnCapNhat);

		btnXoa = new JButton("X??a");
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnXoa.setBounds(355, 309, 124, 30);
		pnlTim.add(btnXoa);

		btnTimMa = new JButton("T??m ki???m theo m??");
		btnTimMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimMa.setBounds(209, 61, 235, 30);
		pnlTim.add(btnTimMa);

		btnTimCMND = new JButton("T??m Theo CMND");
		btnTimCMND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimCMND.setBounds(209, 141, 235, 30);
		pnlTim.add(btnTimCMND);

		btnTimSDT = new JButton("T??m Theo SDT");
		btnTimSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimSDT.setBounds(209, 227, 235, 30);
		pnlTim.add(btnTimSDT);

		btnThoat = new JButton("Tho??t");
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThoat.setBounds(355, 351, 121, 32);
		pnlTim.add(btnThoat);

		btnQuayLai = new JButton("Quay l???i");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuayLai.setBounds(221, 351, 124, 32);
		pnlTim.add(btnQuayLai);

		JSeparator separator = new JSeparator();
		separator.setBounds(40, 271, 439, 2);
		pnlTim.add(separator);

		btnHienBang = new JButton("Hi???n b???ng");

		btnHienBang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHienBang.setBounds(87, 332, 124, 32);
		pnlTim.add(btnHienBang);

		JPanel pnlNhap = new JPanel();
		pnlNhap.setLayout(null);
		pnlNhap.setBackground(Color.LIGHT_GRAY);
		pnlNhap.setBounds(28, 35, 512, 411);
		panelTop.add(pnlNhap);

		JLabel lblMaNV = new JLabel("M?? nh??n vi??n:");
		lblMaNV.setForeground(Color.BLACK);
		lblMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaNV.setBounds(20, 10, 124, 24);
		pnlNhap.add(lblMaNV);

		JLabel lblTenNV = new JLabel("T??n nh??n vi??n:");
		lblTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenNV.setBounds(20, 50, 144, 24);
		pnlNhap.add(lblTenNV);

		JLabel lblNgaySinh = new JLabel("Ng??y sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgaySinh.setBounds(20, 89, 127, 24);
		pnlNhap.add(lblNgaySinh);

		JLabel lblGioiTinh = new JLabel("Gi???i t??nh:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGioiTinh.setBounds(20, 130, 127, 25);
		pnlNhap.add(lblGioiTinh);

		radNam = new JRadioButton("Nam");
		radNam.setSelected(true);
		radNam.setFont(new Font("Times New Roman", Font.BOLD, 20));
		radNam.setBounds(176, 130, 77, 21);
		pnlNhap.add(radNam);

		radNu = new JRadioButton("N???");
		radNu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		radNu.setBounds(286, 130, 67, 21);
		pnlNhap.add(radNu);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radNam);
		btnGroup.add(radNu);

		JLabel lblCMND = new JLabel("CMND/CCCD:");
		lblCMND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCMND.setBounds(20, 176, 138, 24);
		pnlNhap.add(lblCMND);

		JLabel lblChucVu = new JLabel("Ch???c v???:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblChucVu.setBounds(20, 219, 127, 24);
		pnlNhap.add(lblChucVu);

		JLabel lblDiaChi = new JLabel("?????a ch???:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDiaChi.setBounds(20, 263, 127, 24);
		pnlNhap.add(lblDiaChi);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(20, 365, 127, 24);
		pnlNhap.add(lblEmail);

		JLabel lblSDT = new JLabel("S??? ??i???n tho???i:");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSDT.setBounds(20, 311, 127, 24);
		pnlNhap.add(lblSDT);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(176, 10, 303, 30);
		pnlNhap.add(txtMaNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(176, 49, 303, 30);
		pnlNhap.add(txtTenNV);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(176, 89, 303, 30);
		pnlNhap.add(txtNgaySinh);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCMND.setColumns(10);
		txtCMND.setBounds(176, 176, 303, 30);
		pnlNhap.add(txtCMND);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(176, 266, 303, 30);
		pnlNhap.add(txtDiaChi);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(176, 311, 303, 30);
		pnlNhap.add(txtSDT);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(176, 365, 303, 30);
		pnlNhap.add(txtEmail);

		cmbChucVu = new JComboBox<String>();
		cmbChucVu.addItem("Qu???n l??");
		cmbChucVu.addItem("Nh??n vi??n b??n h??ng");
		cmbChucVu.addItem("Qu???n l?? c???p cao");
		cmbChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbChucVu.setBounds(176, 218, 303, 30);
		pnlNhap.add(cmbChucVu);

		JLabel lblTieuDe = new JLabel("Qu???n L?? Th??ng Tin Nh??n Vi??n");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(581, 0, 345, 39);
		panelTop.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JPanel pnlHinh = new JPanel();
		pnlHinh.setBounds(582, 36, 308, 410);
		panelTop.add(pnlHinh);
		pnlHinh.setLayout(null);

		lblHinh = new JLabel();
		lblHinh.setBounds(58, 24, 200, 250);
		pnlHinh.add(lblHinh);

		btnChonHinh = new JButton("Ch???n h??nh");
		btnChonHinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnChonHinh.setBounds(98, 313, 124, 30);
		pnlHinh.add(btnChonHinh);

		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(Color.LIGHT_GRAY);
		panelBottom.setBounds(10, 478, 1466, 300);
		Box b, b7;
		panelBottom.add(b = Box.createHorizontalBox());
		panelBottom.add(b7 = Box.createHorizontalBox());
		String[] headers = { "M?? nh??n vi??n", "T??n nh??n vi??n", "Ng??y Sinh", "Gi???i T??nh", "CMND/CCCD", "Ch???c V???",
				"?????a Ch???", "SDT", "Email", "H??nh" };
		dataModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll;
		b.add(scroll = new JScrollPane(tbl = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh s??ch nh??n vi??n"));
		contentPane.add(panelBottom);
		panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.X_AXIS));

		tbl.addMouseListener(this);
		btnHienBang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnChonHinh.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnThoat.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnTimMa.addActionListener(this);
		btnTimCMND.addActionListener(this);
		btnTimSDT.addActionListener(this);
		Database.getInstance().connect();
		hienTable();
	}

	private void hienTable() {
		String gioiTinh;
		List<NhanVien> dsnv = nvDao.docDatabase();
		for (NhanVien nv : dsnv) {
			if (nv.isGioiTinh())
				gioiTinh = "Nam";
			else
				gioiTinh = "N???";
			String[] row = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh() + "", gioiTinh, nv.getSoCMND(),
					nv.getTenChucVu(), nv.getDiaChi(), nv.getSdtNhanVien(), nv.getEmail(), nv.getHinh() };
			dataModel.addRow(row);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		txtMaNV.setEditable(false);
		int row = tbl.getSelectedRow();
		if (row != -1) {
			txtMaNV.setText((String) tbl.getValueAt(row, 0));
			txtTenNV.setText((String) tbl.getValueAt(row, 1));
			txtNgaySinh.setText(tbl.getValueAt(row, 2).toString());
			if (tbl.getValueAt(row, 3).equals("Nam"))
				radNam.setSelected(true);
			else
				radNu.setSelected(true);
			txtCMND.setText((String) tbl.getValueAt(row, 4));
			cmbChucVu.setSelectedItem(tbl.getValueAt(row, 5));
			txtDiaChi.setText((String) tbl.getValueAt(row, 6));
			txtSDT.setText((String) tbl.getValueAt(row, 7));
			txtEmail.setText((String) tbl.getValueAt(row, 8));
			dir = (String) tbl.getValueAt(row, 9);
			lblHinh.setIcon(new ImageIcon(dir));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnHienBang)) {
			hienTable();
		}
	else if (src.equals(btnXoa))
			xoa();
		else if (src.equals(btnChonHinh))
			themHinh();
		else if (src.equals(btnCapNhat))
			capNhat();
		
		else if (src.equals(btnTimMa)) {
			timTheoMa();
		}
		else if (src.equals(btnTimCMND)) {
			timTheoCMND();
		}
		else if (src.equals(btnTimSDT)) {
			timTheoSDT();
		}
		else if (src.equals(btnThoat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n k???t th??c?", "Th??ng B??o",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (src.equals(btnQuayLai)) {
			dispose();
			new FrmIndex(FrmDangNhap.getIdn()).setVisible(true);
		}
	}
	public void xoaHetTable() {
		DefaultTableModel dm = (DefaultTableModel) tbl.getModel();
		dm.getDataVector().removeAllElements();
	}
	private void timTheoMa() {
		String maNV = txtTimMa.getText();
		String gioiTinh;
		if (!maNV.equals("")) {
			NhanVien nv = nvDao.getNhanVienTheoMa(maNV);
			if (nv!=null) {
				xoaHetTable();
				if (nv.isGioiTinh()==true) {
					 gioiTinh = "Nam";
				} else {
					 gioiTinh = "N???";
				}
				String[] row = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh() + "", gioiTinh, nv.getSoCMND(),
						nv.getTenChucVu(), nv.getDiaChi(), nv.getSdtNhanVien(), nv.getEmail(), nv.getHinh() };
				dataModel.addRow(row);
			} else {
				JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p m?? nh??n vi??n !   ");
		}

	}
	
	
	private void timTheoCMND() {
		String cmndNV = txtTimCMND.getText();
		String gioiTinh;
		if (!cmndNV.equals("")) {
			NhanVien nv = nvDao.getNhanVienTheoCMND(cmndNV);
			if (nv!=null) {
				xoaHetTable();
				if (nv.isGioiTinh()==true) {
					 gioiTinh = "Nam";
				} else {
					 gioiTinh = "N???";
				}
				String[] row = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh() + "", gioiTinh, nv.getSoCMND(),
						nv.getTenChucVu(), nv.getDiaChi(), nv.getSdtNhanVien(), nv.getEmail(), nv.getHinh() };
				dataModel.addRow(row);
			} else {
				JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p CMND nh??n vi??n !   ");
		}

	}
	
	private void timTheoSDT() {
		String sdt = txtTimSDT.getText();
		String gioiTinh;
		if (!sdt.equals("")) {
			NhanVien nv = nvDao.getNhanVienTheoSDT(sdt);
			if (nv!=null) {
				xoaHetTable();
				if (nv.isGioiTinh()==true) {
					 gioiTinh = "Nam";
				} else {
					 gioiTinh = "N???";
				}
				String[] row = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh() + "", gioiTinh, nv.getSoCMND(),
						nv.getTenChucVu(), nv.getDiaChi(), nv.getSdtNhanVien(), nv.getEmail(), nv.getHinh() };
				dataModel.addRow(row);
			} else {
				JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p CMND nh??n vi??n !   ");
		}

	}
	private void themHinh() {
		fch = new JFileChooser("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\IMGNhanVien");
		int state = fch.showOpenDialog(this);
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fch.getSelectedFile();
			dir = file.getAbsolutePath();
			lblHinh.setIcon(new ImageIcon(dir));
		}
	}

	private void capNhat() {
		int row = tbl.getSelectedRow();
		if (row != -1) {
			if (validData()) {
				String gt;
				String maNV = txtMaNV.getText();
				String tenNV = txtTenNV.getText();
				LocalDate ngaySinh = LocalDate.parse(txtNgaySinh.getText());
				boolean gioiTinh = radNam.isSelected();
				String cmnd = txtCMND.getText();
				String chucVu = cmbChucVu.getSelectedItem().toString();
				String diaChi = txtDiaChi.getText();
				String sdt = txtSDT.getText();
				String email = txtEmail.getText();
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, cmnd, chucVu, dir, diaChi, sdt, email);
				if (nvDao.capNhat(nv)) {
					if (gioiTinh)
						gt = "Nam";
					else
						gt = "N???";
					tbl.setValueAt(maNV, row, 0);
					tbl.setValueAt(tenNV, row, 1);
					tbl.setValueAt(txtNgaySinh.getText(), row, 2);
					tbl.setValueAt(gt, row, 3);
					tbl.setValueAt(cmnd, row, 4);
					tbl.setValueAt(chucVu, row, 5);
					tbl.setValueAt(diaChi, row, 6);
					tbl.setValueAt(sdt, row, 7);
					tbl.setValueAt(email, row, 8);
					tbl.setValueAt(dir, row, 9);
					JOptionPane.showMessageDialog(this, "???? c???p nh???t!");
				} else
					JOptionPane.showMessageDialog(this, "C???p nh???t th???t b???i!");
			}
		} else
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n nh??n vi??n!");
	}

	private void xoa() {
		int row = tbl.getSelectedRow();
		if (row != -1) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n xo?? nh??n vi??n n??y kh??ng?", "Ch?? ??",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				String maNV = (String) tbl.getValueAt(row, 0);
				if (tkDao.delete(maNV) && nvDao.xoa(maNV)) {
					dataModel.removeRow(row);
					JOptionPane.showMessageDialog(this, "???? xo??!");
				} else
					JOptionPane.showMessageDialog(this, "Xo?? th???t b???i!");
			}
		} else
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n nh??n vi??n!");
	}

	private boolean validData() {
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		String cmnd = txtCMND.getText();
		String chucVu = cmbChucVu.getSelectedItem().toString();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();

		if (!(maNV.length() > 0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p m?? nh??n vi??n!");
			txtMaNV.selectAll();
			txtMaNV.requestFocus();
			return false;
		} else {
			if (chucVu.equals("Qu???n l??")) {
				if (!(maNV.matches("NVQL[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this,
							"M?? nh??n vi??n nh???p theo m???u NVQLXXX (X:s??? b???t k??), VD: NVQL123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
			if (chucVu.equals("Nh??n vi??n b??n h??ng")) {
				if (!(maNV.matches("NVBH[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this,
							"M?? nh??n vi??n nh???p theo m???u NVBHXXX (X:s??? b???t k??), VD: NVBH123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}

			if (chucVu.equals("Qu???n l?? c???p cao")) {
				if (!(maNV.matches("QLCC[0-9]{1,}"))) {
					JOptionPane.showMessageDialog(this,
							"M?? nh??n vi??n nh???p theo m???u QLCCXXX (X:s??? b???t k??), VD: QLCC123!");
					txtMaNV.selectAll();
					txtMaNV.requestFocus();
					return false;
				}
			}
		}

		if (!(tenNV.length() > 0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p t??n nh??n vi??n!");
			txtTenNV.selectAll();
			txtTenNV.requestFocus();
			return false;
		}

		try {
			LocalDate.parse(txtNgaySinh.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ng??y sinh nh???p theo ?????nh d???ng yyyy-mm-dd, VD: 1990-03-20");
			txtNgaySinh.selectAll();
			txtNgaySinh.requestFocus();
			return false;
		}

		if (!(cmnd.length() > 0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p s??? CMND/CCCD!");
			txtCMND.selectAll();
			txtCMND.requestFocus();
			return false;
		} else {
			if (!(cmnd.matches("[0-9]{9,12}"))) {
				JOptionPane.showMessageDialog(this, "S??? CMND/CCCD ph???i nh???p ?????y ????? t??? 9 ?????n 12 s???!");
				txtCMND.selectAll();
				txtCMND.requestFocus();
				return false;
			}
		}

		if (!(diaChi.length() > 0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p ?????a ch???!");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		}

		if (!(sdt.length() > 0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p s??? ??i???n tho???i!");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		} else {
			if (!(sdt.matches("[0-9]{10}"))) {
				JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i ph???i nh???p ?????y ????? 10 s???!");
				txtSDT.selectAll();
				txtSDT.requestFocus();
				return false;
			}
		}

		if (!(email.length() > 0)) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p email!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}

		if (dir == null) {
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n h??nh!");
			return false;
		} else {
			if (!(dir.matches(".*(.png|.jpg|.gif)|(.PNG|.JPG|.GIF)$"))) {
				JOptionPane.showMessageDialog(this, "H??nh ph???i l?? png, jpg, gif!");
				return false;
			}
		}
		return true;
	}
}