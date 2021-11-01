package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class FrmQuenMatKhau extends JFrame implements ActionListener, MouseListener {

	private JPanel pnlPane;
	private JTextField txtNhapTaiKhoan;
	private JTextField txtNhapMa;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnQuayLai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuenMatKhau frame = new FrmQuenMatKhau();
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
	public FrmQuenMatKhau() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 20, 874, 508);
		pnlPane = new JPanel();
		pnlPane.setBackground(Color.GRAY);
		pnlPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPane);
		pnlPane.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("ĐỔI MẬT KHẨU");
		lblTieuDe.setForeground(Color.YELLOW);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblTieuDe.setBounds(345, 10, 290, 50);
		pnlPane.add(lblTieuDe);
		
		JLabel lblNhapTaiKhoan = new JLabel("Nhập tài khoản:");
		lblNhapTaiKhoan.setForeground(Color.YELLOW);
		lblNhapTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNhapTaiKhoan.setBounds(28, 86, 182, 35);
		pnlPane.add(lblNhapTaiKhoan);
		
		JLabel lblNhapMK = new JLabel("Nhập mật khẩu mới:");
		lblNhapMK.setForeground(Color.YELLOW);
		lblNhapMK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNhapMK.setBounds(28, 160, 182, 27);
		pnlPane.add(lblNhapMK);
		
		JLabel lblNhapLaiMK = new JLabel("Nhập lại mật khẩu:");
		lblNhapLaiMK.setForeground(Color.YELLOW);
		lblNhapLaiMK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNhapLaiMK.setBounds(28, 225, 182, 27);
		pnlPane.add(lblNhapLaiMK);
		
		JLabel lblLayMa = new JLabel("Nhập mã xác thực:");
		lblLayMa.setForeground(Color.YELLOW);
		lblLayMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLayMa.setBounds(28, 287, 166, 27);
		pnlPane.add(lblLayMa);
		
		txtNhapTaiKhoan = new JTextField();
		txtNhapTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtNhapTaiKhoan.setBounds(230, 86, 611, 35);
		pnlPane.add(txtNhapTaiKhoan);
		txtNhapTaiKhoan.setColumns(10);
		
		txtNhapMa = new JTextField();
		txtNhapMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtNhapMa.setColumns(10);
		txtNhapMa.setBounds(230, 285, 611, 35);
		pnlPane.add(txtNhapMa);
		
		JButton btnLayMa = new JButton("Lấy mã");
		
		btnLayMa.setForeground(Color.RED);
		btnLayMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLayMa.setBounds(345, 354, 120, 35);
		pnlPane.add(btnLayMa);
		
		JButton btnLuu = new JButton("Lưu");
		
		btnLuu.setForeground(Color.RED);
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLuu.setBounds(494, 354, 120, 35);
		pnlPane.add(btnLuu);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 415, 795, 2);
		pnlPane.add(separator);
		
		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnQuayLai.setBounds(421, 437, 120, 35);
		pnlPane.add(btnQuayLai);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passwordField.setBounds(230, 158, 611, 35);
		pnlPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passwordField_1.setBounds(230, 223, 611, 35);
		pnlPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\PasswordResetShareFile.jpg"));
		lblNewLabel.setBounds(0, 0, 874, 508);
		pnlPane.add(lblNewLabel);
		btnQuayLai.addActionListener(this);
		Database.getInstance().connect();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnQuayLai)) {
			dispose();
			new FrmDangNhap().setVisible(true);
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
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
