package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class FrmThongTinCaNhan extends JFrame implements ActionListener, MouseListener {

	private JPanel pnlPane;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtNgaySinh;
	private JTextField txtCNND;
	private JTextField txtChucVu;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JButton btnLuu;
	private NhanVien_DAO nvDao = new NhanVien_DAO();
	private JLabel lblAnh;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JButton btnQuayLai;
	private JButton btnDoiMatKhau;

	
	/**
	 * Create the frame.
	 */
	public FrmThongTinCaNhan() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(150, 20, 1200, 668);
		pnlPane = new JPanel();
		pnlPane.setBackground(new Color(255, 235, 205));
		pnlPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPane);
		pnlPane.setLayout(null);

		JLabel lblTieuDe = new JLabel("Thông Tin Cá Nhân");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblTieuDe.setBounds(541, 1, 345, 47);
		pnlPane.add(lblTieuDe);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(new Color(211, 211, 211));
		pnlLeft.setBounds(32, 58, 795, 464);
		pnlPane.add(pnlLeft);
		pnlLeft.setLayout(null);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaNhanVien.setForeground(new Color(0, 0, 0));
		lblMaNhanVien.setBounds(20, 10, 127, 25);
		pnlLeft.add(lblMaNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaNhanVien.setBounds(176, 10, 582, 30);
		pnlLeft.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		JLabel lblTenNhanVien = new JLabel("Tên nhân viên:");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenNhanVien.setBounds(20, 50, 144, 24);
		pnlLeft.add(lblTenNhanVien);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTenNhanVien.setBounds(176, 49, 582, 30);
		pnlLeft.add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);

		JLabel lblNgaySinh = new JLabel("Ngày sinh:");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNgaySinh.setBounds(20, 89, 127, 24);
		pnlLeft.add(lblNgaySinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtNgaySinh.setBounds(176, 89, 582, 30);
		pnlLeft.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblGioiTinh.setBounds(20, 130, 127, 25);
		pnlLeft.add(lblGioiTinh);

		rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNewRadioButton.setBounds(321, 132, 77, 33);
		pnlLeft.add(rdbtnNewRadioButton);

		 rdbtnNewRadioButton_1 = new JRadioButton("Nữ");
		 rdbtnNewRadioButton_1.setEnabled(false);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		rdbtnNewRadioButton_1.setBounds(458, 132, 67, 33);
		pnlLeft.add(rdbtnNewRadioButton_1);

		JLabel lblCMND = new JLabel("CMND/CCCD:");
		lblCMND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCMND.setBounds(20, 176, 138, 24);
		pnlLeft.add(lblCMND);

		txtCNND = new JTextField();
		txtCNND.setEditable(false);
		txtCNND.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCNND.setBounds(176, 176, 582, 30);
		pnlLeft.add(txtCNND);
		txtCNND.setColumns(10);

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblChucVu.setBounds(20, 219, 127, 24);
		pnlLeft.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtChucVu.setBounds(176, 219, 582, 30);
		pnlLeft.add(txtChucVu);
		txtChucVu.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDiaChi.setBounds(20, 263, 127, 24);
		pnlLeft.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDiaChi.setBounds(176, 266, 582, 30);
		pnlLeft.add(txtDiaChi);
		txtDiaChi.setColumns(10);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSDT.setBounds(20, 308, 127, 24);
		pnlLeft.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSDT.setBounds(176, 311, 582, 30);
		pnlLeft.add(txtSDT);
		txtSDT.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(20, 365, 127, 24);
		pnlLeft.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtEmail.setBounds(176, 365, 582, 30);
		pnlLeft.add(txtEmail);
		txtEmail.setColumns(10);

		Panel pnlRight = new Panel();
		pnlRight.setBackground(new Color(211, 211, 211));
		pnlRight.setBounds(863, 58, 308, 464);
		pnlPane.add(pnlRight);
		pnlRight.setLayout(null);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDoiMatKhau.setBounds(78, 401, 157, 30);
		pnlRight.add(btnDoiMatKhau);

		lblAnh = new JLabel("");
		lblAnh.setBounds(55, 43, 200, 282);
		pnlRight.add(lblAnh);
		lblAnh.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\IMGNhanVien\\Chu.jpg"));

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLuu.setBounds(229, 565, 117, 33);
		pnlPane.add(btnLuu);

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnQuayLai.setBounds(389, 565, 117, 33);
		pnlPane.add(btnQuayLai);
		
		btnQuayLai.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		Database.getInstance().connect();
		
		nvDao.getThongTin(FrmDangNhap.getIdnv(),txtMaNhanVien, txtTenNhanVien, txtNgaySinh, rdbtnNewRadioButton, rdbtnNewRadioButton_1,
				 txtCNND, txtChucVu, txtDiaChi, txtSDT, txtEmail, lblAnh);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnQuayLai)) {
			dispose();
			new FrmIndex(FrmDangNhap.getIdn()).setVisible(true);
		}
		else if (object.equals(btnDoiMatKhau)) {
			dispose();
			new FrmDoiMatKhau().setVisible(true);
		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	
}
