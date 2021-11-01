package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import dao.SanPham_DAO;
import entity.SanPham;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class FrmSanPham extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtDonGia;
	private JButton btnThemAnh;
	private String IMGAnhMau;
	private JLabel lblAnh;
	private JFileChooser fch;
	private File file;
	private String dir;
	private JLabel lblHinh;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private SanPham_DAO spDao;
	private JButton btnQuayLai;
	private JComboBox cmbDonVi;
	private JComboBox cmbNhaCungCap;
	private JTextField txtSoLuongCon;
	private JComboBox cmbLoaiSanPham;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSanPham frame = new FrmSanPham();
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
	public FrmSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1037, 648);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u00CAM S\u1EA2N PH\u1EA8M");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 34));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(381, 10, 277, 48);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 55, 583, 526);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setBounds(10, 10, 166, 30);
		panel.add(lblMaSP);
		lblMaSP.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(203, 13, 359, 30);
		panel.add(txtMaSP);
		txtMaSP.setToolTipText("*B\u1EAFt \u0111\u1EA7u b\u1EB1ng 2 ch\u1EEF c\u00E1i SP");
		txtMaSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaSP.setColumns(10);
		
		JLabel lblTenSP = new JLabel("Tên sản phẩm:");
		lblTenSP.setBounds(10, 61, 166, 30);
		panel.add(lblTenSP);
		lblTenSP.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		txtTenSP = new JTextField();
		txtTenSP.setBounds(203, 64, 359, 30);
		panel.add(txtTenSP);
		txtTenSP.setToolTipText("*B\u1EAFt \u0111\u00E2u b\u1EB1ng ch\u1EEF in hoa");
		txtTenSP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenSP.setColumns(10);
		
		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setBounds(10, 195, 166, 30);
		panel.add(lblDonGia);
		lblDonGia.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		txtDonGia = new JTextField();
		txtDonGia.setBounds(203, 197, 359, 30);
		panel.add(txtDonGia);
		txtDonGia.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDonGia.setColumns(10);
		
		JLabel lblLoaiSanPham = new JLabel("Loại sản phẩm:");
		lblLoaiSanPham.setBounds(10, 113, 166, 30);
		panel.add(lblLoaiSanPham);
		lblLoaiSanPham.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		cmbLoaiSanPham = new JComboBox();
		cmbLoaiSanPham.setBounds(203, 117, 359, 30);
		cmbLoaiSanPham.addItem("Sách");
		panel.add(cmbLoaiSanPham);
		
		JLabel lblDonVi = new JLabel("Đơn vị :");
		lblDonVi.setBounds(10, 153, 166, 30);
		panel.add(lblDonVi);
		lblDonVi.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblNhaCungCap = new JLabel("Nhà cung cấp:");
		lblNhaCungCap.setBounds(10, 311, 166, 30);
		panel.add(lblNhaCungCap);
		lblNhaCungCap.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		btnLuu = new JButton("Lưu");
		
		btnLuu.setBounds(215, 403, 118, 43);
		panel.add(btnLuu);
		btnLuu.setForeground(Color.RED);
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(364, 403, 166, 43);
		panel.add(btnXoaTrang);
		btnXoaTrang.setForeground(Color.RED);
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 372, 563, 21);
		panel.add(separator);
		
		cmbNhaCungCap = new JComboBox();
		cmbNhaCungCap.setBounds(203, 315, 359, 30);
		cmbNhaCungCap.addItem("CÔNG TY CỔ PHẦN ANH PHƯỚC");
		panel.add(cmbNhaCungCap);
		
		cmbDonVi = new JComboBox();
		cmbDonVi.setModel(new DefaultComboBoxModel(new String[] {"Cuốn"}));
		cmbDonVi.setBounds(203, 157, 359, 30);
		cmbDonVi.addItem("Sách");
		panel.add(cmbDonVi);
		
		JLabel lblSoLuongCon = new JLabel("Số Lượng Còn:");
		lblSoLuongCon.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSoLuongCon.setBounds(10, 257, 166, 30);
		panel.add(lblSoLuongCon);
		
		txtSoLuongCon = new JTextField();
		txtSoLuongCon.setBounds(203, 257, 358, 30);
		panel.add(txtSoLuongCon);
		txtSoLuongCon.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(603, 55, 410, 526);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnQuayLai = new JButton("QUAY L\u1EA0I");
		btnQuayLai.setBounds(39, 424, 139, 37);
		panel_1.add(btnQuayLai);
		btnQuayLai.setForeground(Color.RED);
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnThoat = new JButton("THO\u00C1T");
		btnThoat.setBounds(248, 424, 127, 37);
		panel_1.add(btnThoat);
		btnThoat.setForeground(Color.RED);
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btnThemAnh = new JButton("TH\u00CAM \u1EA2NH");
		btnThemAnh.setForeground(Color.RED);
		btnThemAnh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThemAnh.setBounds(132, 362, 161, 44);
		panel_1.add(btnThemAnh);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(93, 22, 231, 319);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblAnh = new JLabel("");
	
		lblAnh.setBounds(19, 20, 200, 277);
		panel_2.add(lblAnh);

		btnThemAnh.addActionListener(this);
		btnLuu.addActionListener(this);
		Database.getInstance().connect();
	}


	private void themAnh() {
		fch= new JFileChooser("D:\\PTUD-QLHS\\Nhom09-DeTai02-PTUD-15BTT-2021\\IMGSanPham");
		int state = fch.showOpenDialog(this);
		if(state==JFileChooser.APPROVE_OPTION) {
			file= fch.getSelectedFile();
			dir=file.getAbsolutePath();
			lblAnh.setIcon(new ImageIcon(dir));
		}
	}
	public void luu () {
		SanPham sp = new SanPham( txtMaSP.getText(), txtTenSP.getText(), cmbLoaiSanPham.getSelectedItem().toString(), cmbDonVi.getSelectedItem().toString(), Double.parseDouble(txtDonGia.getText()), Integer.parseInt(txtSoLuongCon.getText()), dir);
		if(spDao.create(sp))
			JOptionPane.showMessageDialog(this, "Đã lưu!");
		else
			JOptionPane.showMessageDialog(this, "Không lưu được!");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object.equals(btnThemAnh)) {
			themAnh();
		}
		else if (object.equals(btnLuu)) {
			luu();
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
