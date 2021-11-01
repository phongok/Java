package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class FrmKhachHang extends JFrame implements ActionListener, MouseListener {

	private JPanel pnlPane;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKH;
	private JTextField txtEmail;
	private JButton btnTTT;
	private JButton btnXoaTrang;
	private JButton btnThoat;
	private KhachHang_DAO khDao = new KhachHang_DAO();
	private JButton btnLuu;
	private JButton btnQuayLai;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmKhachHang frame = new FrmKhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrmKhachHang() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(400, 100, 823, 472);
		pnlPane = new JPanel();
		pnlPane.setBackground(new Color(192, 192, 192));
		pnlPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPane);
		pnlPane.setLayout(null);

		JLabel lblTieuDe = new JLabel("Thêm Thông Tin Khách Hàng");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTieuDe.setBounds(257, 10, 346, 30);
		pnlPane.add(lblTieuDe);

		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng:");
		lblMaKhachHang.setForeground(Color.RED);
		lblMaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaKhachHang.setBounds(20, 53, 158, 23);
		pnlPane.add(lblMaKhachHang);

		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setForeground(Color.RED);
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenKhachHang.setBounds(20, 103, 158, 23);
		pnlPane.add(lblTenKhachHang);

		JLabel lblSDTKH = new JLabel("Số Điện Thoại:");
		lblSDTKH.setForeground(Color.RED);
		lblSDTKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSDTKH.setBounds(20, 154, 158, 23);
		pnlPane.add(lblSDTKH);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.RED);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(20, 200, 158, 23);
		pnlPane.add(lblEmail);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setToolTipText(
				"*Ghi chú: mã khách hàng bắt đầu bằng KH sau đó tên khách hàng và số điện thoại. *VD: KHPHONG0358995904");
		txtMaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaKhachHang.setBounds(200, 50, 576, 30);
		pnlPane.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setToolTipText("*Nhập đầy đủ hộ tên, chữ cái đầu viết hoa");
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTenKhachHang.setBounds(200, 100, 576, 30);
		pnlPane.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSDTKH.setBounds(200, 151, 576, 30);
		pnlPane.add(txtSDTKH);
		txtSDTKH.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("*Nhập theo dạng xxx@gmail.com. Ví dụ: hieusachnguyenphong6666@gmail.com");
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtEmail.setBounds(200, 197, 576, 30);
		pnlPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnLuu = new JButton("Lưu");

		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnLuu.setBounds(354, 280, 110, 30);
		pnlPane.add(btnLuu);

		btnTTT = new JButton("Tiến Hành Tạo Hóa Đơn");
		btnTTT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTTT.setBounds(353, 328, 322, 30);
		pnlPane.add(btnTTT);

		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXoaTrang.setBounds(512, 280, 158, 30);
		pnlPane.add(btnXoaTrang);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnThoat.setBounds(685, 409, 85, 30);
		pnlPane.add(btnThoat);

		btnQuayLai = new JButton("Quay Lại");
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuayLai.setBounds(555, 409, 120, 30);
		pnlPane.add(btnQuayLai);

		JSeparator spr2 = new JSeparator();
		spr2.setBounds(32, 387, 744, 2);
		pnlPane.add(spr2);

		JSeparator spr1 = new JSeparator();
		spr1.setBounds(32, 258, 744, 2);
		pnlPane.add(spr1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 823, 472);
		pnlPane.add(lblNewLabel);

		btnLuu.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThoat.addActionListener(this);
		btnQuayLai.addActionListener(this);
		Database.getInstance().connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			KhachHang kh = new KhachHang(txtMaKhachHang.getText(), txtTenKhachHang.getText(), txtSDTKH.getText(),
					txtEmail.getText());
			if (valibData() == true) {
				if (khDao.create(kh)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
				}
				else {
					JOptionPane.showMessageDialog(this, "Thêm thất bại công!");
				}
			}
			
		} else if (o.equals(btnXoaTrang)) {
			xoaRongTextfields();
			
		}
		else if (o.equals(btnThoat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn kết thúc?", "Thông Báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		
		else if (o.equals(btnQuayLai)) {
			dispose();
			new FrmIndex(FrmDangNhap.getIdn()).setVisible(true);
		}

	}

	private void xoaRongTextfields() {
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtSDTKH.setText("");
		txtEmail.setText("");
	}
	public boolean valibData() {
		String maKHang = txtMaKhachHang.getText().trim();
		String tenKhachHang = txtTenKhachHang.getText().trim();
		String sdtKH = txtSDTKH.getText().trim();
		String Email = txtEmail.getText().trim();
		
		if ( maKHang.length() <=0 ) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng khác rỗng , không chứa ký tự đặc biệt" );
		     txtMaKhachHang.requestFocus();
			return false;
		}
		else if (tenKhachHang.length()<=0 || tenKhachHang.matches("^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng khác rỗng , không chứa ký tự đặc biệt, chữ cái đầu viết hoa: VD: Nguyễn Văn A" );
		     txtTenKhachHang.requestFocus();
			return false;
		}
		else if (sdtKH.length() <= 0 || !sdtKH.matches("^0\\d{9}+$")) {
			JOptionPane.showMessageDialog(this, "Số điệ thoại khách hàng khác rỗng , không chứa ký tự đặc biệt và chữ VD: 0986666666" );
		     txtEmail.requestFocus();
		     return false;
		}
		
		return true;
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
