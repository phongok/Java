package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import connectDB.Database;
import dao.KhachHang_DAO;
import dao.NhaCungCap_DAO;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import connectDB.Database;

public class FrmQuanLiNhaCungCap extends JFrame implements ActionListener, MouseListener {

	private JPanel pnlPane;
	private JTextField txtTimSoFax;
	private JTextField txtTimSdt;
	private JTextField txtTenNCC;
	private JTextField txtDiaChiNCC;
	private JTextField txtSDTNCC;
	private JTextField txtSoFax;
	private DefaultTableModel dataModel;
	private JButton btnCapNhat;
	private JButton btnQuayLai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTable table;
	private JButton btnTimSdt;
	private JButton btnTimSoFax;

	private JButton btnHienBang;
	private JTextField txtEmail;
	private JTextField txtWebsite;
	private NhaCungCap_DAO nccDao = new NhaCungCap_DAO();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLiNhaCungCap frame = new FrmQuanLiNhaCungCap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmQuanLiNhaCungCap() {
		setTitle("Quản lí thông tin khách hàng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(10, 10, 1500, 757);
		pnlPane = new JPanel();
		pnlPane.setBackground(Color.BLACK);
		pnlPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPane);
		pnlPane.setLayout(null);

		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(Color.PINK);
		pnlTop.setBounds(10, 10, 1480, 391);
		pnlPane.add(pnlTop);
		pnlTop.setLayout(null);

		JPanel pnlTimKiem = new JPanel();
		pnlTimKiem.setBackground(Color.LIGHT_GRAY);
		pnlTimKiem.setBounds(938, 35, 512, 271);
		pnlTop.add(pnlTimKiem);
		pnlTimKiem.setLayout(null);

		JLabel lblTimSoFax = new JLabel("Tìm theo số FAX:");
		lblTimSoFax.setBounds(10, 21, 154, 24);
		lblTimSoFax.setForeground(Color.BLACK);
		lblTimSoFax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnlTimKiem.add(lblTimSoFax);

		JLabel lblTimSdt = new JLabel("Tìm theo SĐT:");
		lblTimSdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTimSdt.setBounds(10, 135, 157, 24);
		pnlTimKiem.add(lblTimSdt);

		txtTimSoFax = new JTextField();
		txtTimSoFax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTimSoFax.setColumns(10);
		txtTimSoFax.setBounds(176, 18, 303, 30);
		pnlTimKiem.add(txtTimSoFax);

		txtTimSdt = new JTextField();
		txtTimSdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTimSdt.setColumns(10);
		txtTimSdt.setBounds(176, 132, 303, 30);
		pnlTimKiem.add(txtTimSdt);

		btnTimSoFax = new JButton("Tìm kiếm theo số FAX");
		btnTimSoFax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimSoFax.setBounds(209, 61, 235, 30);
		pnlTimKiem.add(btnTimSoFax);

		btnTimSdt = new JButton("Tìm Theo SĐT");
		btnTimSdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimSdt.setBounds(209, 184, 235, 30);
		pnlTimKiem.add(btnTimSdt);

		JPanel pnlNhap = new JPanel();
		pnlNhap.setLayout(null);
		pnlNhap.setBackground(Color.LIGHT_GRAY);
		pnlNhap.setBounds(28, 35, 874, 271);
		pnlTop.add(pnlNhap);

		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp:");
		lblTenNCC.setForeground(new Color(0, 0, 0));
		lblTenNCC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenNCC.setBounds(20, 10, 169, 24);
		pnlNhap.add(lblTenNCC);

		JLabel lblDiaChiNCC = new JLabel("Địa chỉ:");
		lblDiaChiNCC.setForeground(new Color(0, 0, 0));
		lblDiaChiNCC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDiaChiNCC.setBounds(20, 53, 169, 24);
		pnlNhap.add(lblDiaChiNCC);

		JLabel lblSoFax = new JLabel("Số FAX");
		lblSoFax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSoFax.setBounds(20, 133, 169, 24);
		pnlNhap.add(lblSoFax);

		JLabel lblSDTNCC = new JLabel("Số điện thoại:");
		lblSDTNCC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSDTNCC.setBounds(20, 93, 169, 24);
		pnlNhap.add(lblSDTNCC);

		txtTenNCC = new JTextField();
		txtTenNCC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTenNCC.setColumns(10);
		txtTenNCC.setBounds(199, 7, 640, 30);
		pnlNhap.add(txtTenNCC);

		txtDiaChiNCC = new JTextField();
		txtDiaChiNCC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtDiaChiNCC.setColumns(10);

		txtDiaChiNCC.setBounds(199, 50, 640, 30);
		pnlNhap.add(txtDiaChiNCC);

		txtSDTNCC = new JTextField();
		txtSDTNCC.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSDTNCC.setColumns(10);
		txtSDTNCC.setBounds(199, 90, 640, 30);
		pnlNhap.add(txtSDTNCC);

		txtSoFax = new JTextField();
		txtSoFax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSoFax.setColumns(10);
		txtSoFax.setBounds(199, 130, 640, 30);
		pnlNhap.add(txtSoFax);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(199, 170, 640, 30);
		pnlNhap.add(txtEmail);

		txtWebsite = new JTextField();
		txtWebsite.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtWebsite.setColumns(10);
		txtWebsite.setBounds(199, 210, 640, 30);
		pnlNhap.add(txtWebsite);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(20, 181, 169, 24);
		pnlNhap.add(lblEmail);

		JLabel lblWebsite = new JLabel("Website");
		lblWebsite.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblWebsite.setBounds(20, 221, 169, 24);
		pnlNhap.add(lblWebsite);

		JLabel lblTieuDe = new JLabel("Quản Lí Thông Tin Nhà Cung Cấp");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(385, 0, 415, 39);
		pnlTop.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JPanel pnlAction = new JPanel();
		pnlAction.setBackground(Color.LIGHT_GRAY);
		pnlAction.setBounds(28, 318, 1422, 58);
		pnlTop.add(pnlAction);
		pnlAction.setLayout(null);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(new Color(0, 0, 0));
		btnCapNhat.setBackground(Color.CYAN);
		btnCapNhat.setBounds(746, 11, 124, 33);
		pnlAction.add(btnCapNhat);
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(255, 255, 0));
		btnQuayLai.setForeground(new Color(0, 0, 0));
		btnQuayLai.setBounds(919, 12, 118, 30);
		pnlAction.add(btnQuayLai);
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.RED);
		btnXoa.setBounds(570, 10, 124, 30);
		pnlAction.add(btnXoa);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 24));

		btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setBackground(new Color(255, 99, 71));
		btnThoat.setBounds(1086, 12, 124, 30);
		pnlAction.add(btnThoat);
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnHienBang = new JButton("Hiện Bảng");
		btnHienBang.setBackground(new Color(30, 144, 255));
		btnHienBang.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnHienBang.setBounds(333, 11, 178, 29);
		pnlAction.add(btnHienBang);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBackground(Color.LIGHT_GRAY);
		pnlBottom.setBounds(10, 411, 1480, 328);
		Box b1, b2;
		pnlBottom.add(b1 = Box.createHorizontalBox());
		pnlBottom.add(b2 = Box.createHorizontalBox());
		String[] headers = { "Tên nhà cung cấp", "Địa chỉ", "Số Điện Thoại", "Số FAX", "Email", "Website" };
		dataModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll;
		b1.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách nhà cung cấp"));
		pnlPane.add(pnlBottom);
		pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.X_AXIS));

		btnCapNhat.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTimSoFax.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTimSdt.addActionListener(this);
		btnHienBang.addActionListener(this);
		btnQuayLai.addActionListener(this);
		table.addMouseListener(this);
		Database.getInstance().connect();
		updateTableData();
	}

	public void xoaHetTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	private void xoaRongTextfields() {
		txtTenNCC.setText("");
		txtDiaChiNCC.setText("");
		txtSDTNCC.setText("");
		txtSoFax.setText("");
		txtEmail.setText("");
		txtEmail.setText("");
	}

	public void updateTableData() {
		xoaHetTable();
		nccDao.xoaHetDanhSach();
		List<NhaCungCap> list = nccDao.docDatabase();
		for (NhaCungCap nhaCungCap : list) {
			String[] rowData = { nhaCungCap.getTenNhaCungCap(), nhaCungCap.getDiaChi(), nhaCungCap.getSdtNCC(),
					nhaCungCap.getSoFax(), nhaCungCap.getEmail(), nhaCungCap.getWebSite() };
			dataModel.addRow(rowData);
		}
		table.setModel(dataModel);
	}

	private NhaCungCap reverKHFromTextFile() {
		String ten = txtTenNCC.getText().toString();
		String diachi = txtDiaChiNCC.getText().toString();
		String sdt = txtSDTNCC.getText().toString();
		String soFax = txtSoFax.getText().toString();
		String email = txtEmail.getText().toString();
		String web = txtWebsite.getText().toString();
		return new NhaCungCap(ten, diachi, sdt, soFax, email, web);
	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá nhà cung cấp này không?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				String ma = (String) table.getValueAt(row, 0);
				if (nccDao.delete(ma)) {
					dataModel.removeRow(row);
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				} else
					JOptionPane.showMessageDialog(this, "Xoá thất bại!");
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhà cung cấp !");

	}
	private void timTheoSDT() {
		String sdtTim = txtTimSdt.getText();
		if (!sdtTim.equals("")) {
			NhaCungCap ncc = nccDao.getNhaCungCapTheoSoDienThoai(sdtTim);
			if (ncc != null) {
				xoaHetTable();
				String[] rowData = { ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSdtNCC(),
						ncc.getSoFax(), ncc.getEmail(), ncc.getWebSite() };
				dataModel.addRow(rowData);
			} else
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại nhà cung cấp!   ");
	}
	
	private void timTheoSoFax() {
		String soFaxTim = txtTimSoFax.getText();
		if (!soFaxTim.equals("")) {
			NhaCungCap ncc = nccDao.getNhaCungCapTheoSoFax(soFaxTim);
			if (ncc != null) {
				xoaHetTable();
				String[] rowData = { ncc.getTenNhaCungCap(), ncc.getDiaChi(), ncc.getSdtNCC(),
						ncc.getSoFax(), ncc.getEmail(), ncc.getWebSite() };
				dataModel.addRow(rowData);
			} else
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số Fax nhà cung cấp!   ");
	}
	
	private void capNhat() {
		int row = table.getSelectedRow();
		if (row != -1) {
			NhaCungCap ncc = reverKHFromTextFile();
			if (nccDao.update(ncc)) {
				table.setValueAt(txtTenNCC.getText(), row, 0);
				table.setValueAt(txtDiaChiNCC.getText(), row, 1);
				table.setValueAt(txtSDTNCC.getText(), row, 2);
				table.setValueAt(txtSoFax.getText(), row, 3);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
			} else
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn nhà cung cấp!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoa)) {
			xoa();
		} else if (o.equals(btnHienBang)) {
			updateTableData();
		} else if (o.equals(btnCapNhat)) {
			capNhat();
			updateTableData();
		} else if (o.equals(btnHienBang)) {
			updateTableData();
		} else if (o.equals(btnThoat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn kết thúc?", "Thông Báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		else if (o.equals(btnTimSdt)) {
			timTheoSDT();
		}
		else if (o.equals(btnTimSoFax)) {
			timTheoSoFax();
		}
		else if (o.equals(btnQuayLai)) {
			dispose();
			new FrmIndex(FrmDangNhap.getIdn()).setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtTenNCC.setText(table.getValueAt(row, 0).toString());
		txtDiaChiNCC.setText(table.getValueAt(row, 1).toString());
		txtSDTNCC.setText(table.getValueAt(row, 2).toString());
		txtSoFax.setText(table.getValueAt(row, 3).toString());
		txtEmail.setText(table.getValueAt(row, 4).toString());
		txtWebsite.setText(table.getValueAt(row, 5).toString());
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
}