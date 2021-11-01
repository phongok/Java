package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import dao.NhanVien_DAO;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JMenu;
import javax.swing.JTextPane;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class FrmIndex extends JFrame implements ActionListener, MouseListener {

	private JPanel pnlPane;
	private JMenuItem mniDangXuat;
	private JMenuItem mniThemKH;
	private JMenuItem mniQLNCC;
	private JMenuItem mniQLHD;
	private JMenuItem mniQLNV;
	private JMenuItem mniQLKH;
	private JButton btnThoat;
	private JMenuItem mniThemNCC;
	private JMenuItem mniThemNV;
	private JMenuItem mniTT;
	private String tenDangNhap;
	private String tt;
	
	

	

	public FrmIndex(int idn) {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(350, 30, 853, 646);
		setTitle("Chương Trình Quản Lí Mua Bán Hiệu Sách Nguyễn Phong");
		pnlPane = new JPanel();
		pnlPane.setBackground(new Color(216, 191, 216));
		pnlPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(pnlPane);
		pnlPane.setLayout(null);

		JMenuBar mnuBar = new JMenuBar();
		mnuBar.setBounds(0, 0, 852, 55);
		mnuBar.setBackground(new Color(255, 204, 0));
		pnlPane.add(mnuBar);

		JMenu mnCaNhan = new JMenu(" Cá nhân    ");
		mnCaNhan.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-Account.jpg"));
		mnCaNhan.setForeground(new Color(0, 0, 0));
		mnCaNhan.setBackground(SystemColor.menu);
		mnCaNhan.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnuBar.add(mnCaNhan);

		mniTT = new JMenuItem("Thông Tin");
		mniTT.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-ThongTin.jpg"));
		mniTT.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnCaNhan.add(mniTT);

		JSeparator sprCaNhan1 = new JSeparator();
		mnCaNhan.add(sprCaNhan1);

		mniDangXuat = new JMenuItem("Đăng Xuất");
		mniDangXuat.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-DangXuat.jpg"));
		mniDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnCaNhan.add(mniDangXuat);

		JMenu mnThem = new JMenu("Thêm              ");
		mnThem.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-Them.jpg"));
		mnThem.setForeground(new Color(0, 0, 0));
		mnThem.setBackground(SystemColor.menu);
		mnThem.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnuBar.add(mnThem);

		mniThemKH = new JMenuItem("Khách Hàng");
		mniThemKH.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-KhachHang.png"));
		mniThemKH.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnThem.add(mniThemKH);

		JSeparator sprThem1 = new JSeparator();
		mnThem.add(sprThem1);

		mniThemNV = new JMenuItem("Nhân Viên");
		mniThemNV.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-NhanVien.png"));
		mniThemNV.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnThem.add(mniThemNV);
		
				JSeparator sprThem2 = new JSeparator();
				mnThem.add(sprThem2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sản Phẩm");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-Sanpham.jpg"));
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnThem.add(mntmNewMenuItem);
		
				JSeparator sprThem3 = new JSeparator();
				mnThem.add(sprThem3);

		JMenuItem mniThemHD = new JMenuItem("Hóa Đơn");
		mniThemHD.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-HoaDon.png"));
		mniThemHD.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnThem.add(mniThemHD);
		
		JSeparator spr4 = new JSeparator();
		mnThem.add(spr4);

		mniThemNCC = new JMenuItem("Nhà cung cấp");
		mniThemNCC.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-NhaCungCap.png"));
		mniThemNCC.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnThem.add(mniThemNCC);

		JMenu mnQuanLi = new JMenu("Quản Lí          ");
		mnQuanLi.setForeground(Color.BLACK);
		mnQuanLi.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-QuanLi.jpg"));
		mnQuanLi.setBackground(Color.RED);

		mnQuanLi.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnuBar.add(mnQuanLi);

		mniQLKH = new JMenuItem("Khách Hàng");
		mniQLKH.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-KhachHang.png"));
		mniQLKH.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnQuanLi.add(mniQLKH);

		JSeparator sprQL1 = new JSeparator();
		mnQuanLi.add(sprQL1);

		mniQLNV = new JMenuItem("Nhân Viên");
		mniQLNV.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-NhanVien.png"));
		mniQLNV.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnQuanLi.add(mniQLNV);

		JSeparator sprQL2 = new JSeparator();
		mnQuanLi.add(sprQL2);
		
		JMenuItem mniQLSP = new JMenuItem("Sản Phẩm\r\n");
		mniQLSP.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-Sanpham.jpg"));
		mniQLSP.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnQuanLi.add(mniQLSP);
		
		JSeparator sprQL3 = new JSeparator();
		mnQuanLi.add(sprQL3);

		mniQLHD = new JMenuItem("Hóa Đơn");
		mniQLHD.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-HoaDon.png"));
		mniQLHD.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnQuanLi.add(mniQLHD);

		JSeparator sprQL4 = new JSeparator();
		mnQuanLi.add(sprQL4);

		mniQLNCC = new JMenuItem("Nhà cung cấp");
		mniQLNCC.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-NhaCungCap.png"));
		mniQLNCC.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnQuanLi.add(mniQLNCC);

		JMenu mnThongKe = new JMenu("Thống Kê     ");
		mnThongKe.setBackground(new Color(255, 255, 255));
		mnThongKe.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-ThongKe.jpg"));
		mnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnuBar.add(mnThongKe);

		JMenuItem mniTKDT = new JMenuItem("Doanh Thu ");
		mniTKDT.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\Icon-DoanhThu.png"));
		mniTKDT.setFont(new Font("Times New Roman", Font.BOLD, 24));
		mnThongKe.add(mniTKDT);

		JLabel lblBacgound = new JLabel("");
		lblBacgound.setIcon(new ImageIcon("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\Icon\\bg.png"));
		lblBacgound.setForeground(new Color(255, 255, 255));
		lblBacgound.setBackground(new Color(255, 255, 255));
		lblBacgound.setBounds(0, 54, 852, 589);
		pnlPane.add(lblBacgound);

		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(255, 0, 0));
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBounds(701, 605, 131, 31);
		pnlPane.add(btnThoat);
		String tam = tenDangNhap;
		mniDangXuat.addActionListener(this);
		mniTT.addActionListener(this);

		mniThemKH.addActionListener(this);
		mniThemNV.addActionListener(this);
		mniThemNCC.addActionListener(this);

		mniQLKH.addActionListener(this);
		mniQLNV.addActionListener(this);
		mniQLNCC.addActionListener(this);

		btnThoat.addActionListener(this);
		Database.getInstance().connect();
		if (idn == 1) {
			mniThemNV.setVisible(false);
		}
		if (idn == 2) {
			mniThemNV.setVisible(false);
			mnQuanLi.setVisible(false);

		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(mniDangXuat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất hay không", "Thông Báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
				new FrmDangNhap().setVisible(true);
			}
		} else if (obj.equals(mniTT)) {
			dispose();
			new FrmThongTinCaNhan().setVisible(true);
			
		} else if (obj.equals(btnThoat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn kết thúc?", "Thông Báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (obj.equals(mniThemKH)) {
			dispose();
			new FrmKhachHang().setVisible(true);
		} else if (obj.equals(mniThemNV)) {
			dispose();
			new FrmNhanVien().setVisible(true);
		} else if (obj.equals(mniThemNCC)) {
			dispose();
			new FrmNhaCungCap().setVisible(true);
		} else if (obj.equals(mniQLKH)) {
			dispose();
			new FrmQuanLiKhachHang().setVisible(true);
		} else if (obj.equals(mniQLNV)) {
			dispose();
			new FrmQuanLiNhanVien().setVisible(true);
		} else if (obj.equals(mniQLNCC)) {
			dispose();
			new FrmQuanLiNhaCungCap().setVisible(true);
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
