package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import dao.TaiKhoan_DAO;
import entity.TaiKhoan;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class FrmDangNhap extends JFrame implements ActionListener {
	private JButton btnLogin;
	private JTextField txtLogin;
	private JPasswordField pas;
	private TaiKhoan_DAO taiKhoanDao;
	private JButton btnExit;
	private JButton btnQuenMatKhau;
	private static String idnv;
	private static int idn;

	public static int getIdn() {
		return idn;
	}

	public void setIdn(int idn) {
		this.idn = idn;
	}

	

	/**
	 * @return the idnv
	 */
	public static String getIdnv() {
		return idnv;
	}

	/**
	 * @param idnv the idnv to set
	 */
	public static void setIdnv(String idnv) {
		FrmDangNhap.idnv = idnv;
	}

	/**
	 * Create the frame.
	 */
	public FrmDangNhap() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(200, 15, 1077, 599);
		getContentPane().setLayout(null);

		taiKhoanDao = new TaiKhoan_DAO();

		JLabel lblTitle = new JLabel("Form Đăng Nhập");
		lblTitle.setForeground(Color.RED);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitle.setBounds(386, 20, 346, 57);
		getContentPane().add(lblTitle);

		JLabel lblLogin = new JLabel("Tài Khoản");
		lblLogin.setForeground(Color.RED);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLogin.setBounds(532, 191, 145, 48);
		getContentPane().add(lblLogin);

		JLabel lblPassword = new JLabel("Mật Khẩu");
		lblPassword.setForeground(Color.RED);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(532, 272, 111, 48);
		getContentPane().add(lblPassword);

		txtLogin = new JTextField();
		txtLogin.setToolTipText("Bạn hãy nhập tài khoản");
		txtLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtLogin.setBounds(687, 197, 227, 36);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		pas = new JPasswordField();
		pas.setToolTipText("Bạn hãy nhập mật khẩu");
		pas.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pas.setBounds(687, 278, 227, 36);
		getContentPane().add(pas);
		pas.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBackground(Color.CYAN);
		btnLogin.setForeground(Color.RED);
		btnLogin.setBounds(599, 367, 124, 36);
		getContentPane().add(btnLogin);

		btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 140, 0));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(778, 367, 124, 36);
		getContentPane().add(btnExit);

		btnQuenMatKhau = new JButton("Quên mật khẩu");
		btnQuenMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuenMatKhau.setForeground(new Color(220, 20, 60));
		btnQuenMatKhau.setBounds(657, 431, 178, 36);
		getContentPane().add(btnQuenMatKhau);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\imglg.jpg"));
		lblNewLabel_4.setBounds(-11, 10, 1065, 590);
		getContentPane().add(lblNewLabel_4);

		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
		btnQuenMatKhau.addActionListener(this);
		Database.getInstance().connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnLogin))
			dangNhap();

		else if (src.equals(btnExit)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn kết thúc?", "Thông Báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		else if (src.equals(btnQuenMatKhau)) {
			dispose();
			new FrmQuenMatKhau().setVisible(true);
		}

	}

	private void dangNhap() {
		String tenDangNhap = txtLogin.getText();
		String matKhau = pas.getText();
		TaiKhoan taiKhoan = taiKhoanDao.getTaiKhoan(tenDangNhap);
		if (taiKhoan != null && taiKhoan.gettenDN().equals(tenDangNhap) && taiKhoan.getMatKhau().equals(matKhau)) {
			int flag = 0;
			if (taiKhoan.getLoaiTaiKhoan().equals("Quản lí cao cấp")) {
				setIdn(0);
			} else if (taiKhoan.getLoaiTaiKhoan().equals("Quản lí")) {
				setIdn(1);
			} else if (taiKhoan.getLoaiTaiKhoan().equals("Nhân viên bán hàng")) {
				setIdn(2);
			}
			FrmDangNhap.setIdnv(tenDangNhap);
			dispose();
			new FrmIndex(FrmDangNhap.getIdn()).setVisible(true);
		} else
			JOptionPane.showMessageDialog(this, "Bạn đã nhập sai thông tin tài khoản!");
	}
}
