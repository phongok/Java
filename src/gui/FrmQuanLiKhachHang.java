package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import connectDB.Database;
import dao.KhachHang_DAO;
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

public class FrmQuanLiKhachHang extends JFrame implements ActionListener, MouseListener {

	private JPanel pnlPane;
	private JTextField txtTimMa;
	private JTextField txtTimSdt;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSDTKH;
	private JTextField txtEmail;
	private DefaultTableModel dataModel;
	private JButton btnCapNhat;
	private JButton btnQuayLai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTable table;
	private JButton btnTimSdt;
	private JButton btnTimMa;
	private KhachHang_DAO khDao = new KhachHang_DAO();
	private JButton btnHienBang;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLiKhachHang frame = new FrmQuanLiKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FrmQuanLiKhachHang() {
		setTitle("Quản lí thông tin khách hàng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		this.setUndecorated(true);
		setBounds(200, 10, 1134, 757);
		pnlPane = new JPanel();
		pnlPane.setBackground(Color.BLACK);
		pnlPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPane);
		pnlPane.setLayout(null);

		JPanel pnlTop = new JPanel();
		pnlTop.setBackground(Color.PINK);
		pnlTop.setBounds(10, 10, 1112, 391);
		pnlPane.add(pnlTop);
		pnlTop.setLayout(null);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(Color.LIGHT_GRAY);
		pnTimKiem.setBounds(572, 37, 512, 271);
		pnlTop.add(pnTimKiem);
		pnTimKiem.setLayout(null);

		JLabel lblTimMa = new JLabel("Tìm theo mã:");
		lblTimMa.setBounds(40, 21, 124, 24);
		lblTimMa.setForeground(Color.BLACK);
		lblTimMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnTimKiem.add(lblTimMa);

		JLabel lblTimSdt = new JLabel("Tìm theo SDT:");
		lblTimSdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTimSdt.setBounds(37, 146, 127, 24);
		pnTimKiem.add(lblTimSdt);

		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTimMa.setColumns(10);
		txtTimMa.setBounds(176, 18, 303, 30);
		pnTimKiem.add(txtTimMa);

		txtTimSdt = new JTextField();
		txtTimSdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTimSdt.setColumns(10);
		txtTimSdt.setBounds(174, 140, 303, 30);
		pnTimKiem.add(txtTimSdt);

		btnTimMa = new JButton("Tìm kiếm theo mã");
		btnTimMa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimMa.setBounds(209, 61, 235, 30);
		pnTimKiem.add(btnTimMa);

		btnTimSdt = new JButton("Tìm Theo SDT");
		btnTimSdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimSdt.setBounds(209, 189, 235, 30);
		pnTimKiem.add(btnTimSdt);

		JPanel pnNhap = new JPanel();
		pnNhap.setLayout(null);
		pnNhap.setBackground(Color.LIGHT_GRAY);
		pnNhap.setBounds(28, 35, 512, 271);
		pnlTop.add(pnNhap);

		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setForeground(new Color(0, 0, 0));
		lblMaKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMaKH.setBounds(20, 10, 140, 24);
		pnNhap.add(lblMaKH);

		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setForeground(new Color(0, 0, 0));
		lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTenKH.setBounds(22, 86, 144, 24);
		pnNhap.add(lblTenKH);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(20, 203, 127, 24);
		pnNhap.add(lblEmail);

		JLabel lblSdt = new JLabel("Số điện thoại:");
		lblSdt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSdt.setBounds(20, 141, 127, 24);
		pnNhap.add(lblSdt);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(176, 10, 303, 30);
		pnNhap.add(txtMaKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtTenKhachHang.setColumns(10);

		txtTenKhachHang.setBounds(176, 79, 303, 30);
		pnNhap.add(txtTenKhachHang);

		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(176, 138, 303, 30);
		pnNhap.add(txtSDTKH);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(176, 200, 303, 30);
		pnNhap.add(txtEmail);

		JLabel lblTieuDe = new JLabel("Quản Lí Thông Tin Khách Hàng");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setBounds(385, 0, 415, 39);
		pnlTop.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JPanel pnBtn = new JPanel();
		pnBtn.setBackground(Color.LIGHT_GRAY);
		pnBtn.setBounds(28, 318, 1056, 58);
		pnlTop.add(pnBtn);
		pnBtn.setLayout(null);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setForeground(new Color(0, 0, 0));
		btnCapNhat.setBackground(Color.CYAN);
		btnCapNhat.setBounds(596, 11, 124, 33);
		pnBtn.add(btnCapNhat);
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(255, 255, 0));
		btnQuayLai.setForeground(new Color(0, 0, 0));
		btnQuayLai.setBounds(751, 12, 118, 30);
		pnBtn.add(btnQuayLai);
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.RED);
		btnXoa.setBounds(434, 10, 124, 30);
		pnBtn.add(btnXoa);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 24));

		btnThoat = new JButton("Thoát");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setBackground(new Color(255, 99, 71));
		btnThoat.setBounds(897, 12, 124, 30);
		pnBtn.add(btnThoat);
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));

		btnHienBang = new JButton("Hiện Bảng");
		btnHienBang.setBackground(new Color(30, 144, 255));
		btnHienBang.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnHienBang.setBounds(219, 11, 178, 29);
		pnBtn.add(btnHienBang);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBackground(Color.LIGHT_GRAY);
		pnlBottom.setBounds(10, 411, 1112, 328);
		Box b1, b2;
		pnlBottom.add(b1 = Box.createHorizontalBox());
		pnlBottom.add(b2 = Box.createHorizontalBox());
		String[] headers = { "Mã khách hàng", "Tên khách hàng", "Số Điện Thoại", "Email" };
		dataModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll;
		b1.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
		pnlPane.add(pnlBottom);
		pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.X_AXIS));

		btnCapNhat.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTimMa.addActionListener(this);
		btnTimSdt.addActionListener(this);
		btnHienBang.addActionListener(this);
		btnThoat.addActionListener(this);
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
		txtMaKhachHang.setText("");
		txtTenKhachHang.setText("");
		txtSDTKH.setText("");
		txtEmail.setText("");
	}

	public void updateTableData() {
		xoaHetTable();
		khDao.xoaHetDanhSach();
		List<KhachHang> list = khDao.docDatabase();
		for (KhachHang s : list) {
			
			String[] rowData = { s.getMaKH(), s.getTenKH(), s.getSdt(), s.getEmail() };
			dataModel.addRow(rowData);
		}
		table.setModel(dataModel);
	}

	private KhachHang reverKHFromTextFile() {
		String ma = txtMaKhachHang.getText();
		String ten = txtTenKhachHang.getText();
		String sdt = txtSDTKH.getText();
		String email = txtEmail.getText();
		return new KhachHang(ma, ten, sdt, email);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnCapNhat))
			capNhat();
		else if (o.equals(btnXoa))
			xoa();
		else if (o.equals(btnTimMa))
			timMa();
		else if (o.equals(btnHienBang)) {
			updateTableData();
		} else if (o.equals(btnTimSdt)) {
			timTheoSDT();
		
		} else if (o.equals(btnThoat)) {
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

	private void timMa() {
		String maKH = txtTimMa.getText();
		if (!maKH.equals("")) {
			KhachHang kh = khDao.getKhachHangTheoMaKhachHang(maKH);
			if (kh != null) {
				xoaHetTable();
				String[] rowData = { kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail() };
				dataModel.addRow(rowData);
			} else
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã khách hàng!");
	}

	
	private void timTheoSDT() {
		String sdtKH = txtTimSdt.getText();
		if (!sdtKH.equals("")) {
			KhachHang kh = khDao.getKhachHangTheoSoDienThoai(sdtKH);
			if (kh != null) {
				xoaHetTable();
				String[] rowData = { kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail() };
				dataModel.addRow(rowData);
			} else
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại khách hàng!   ");
	}

	private void xoa() {
		int row = table.getSelectedRow();
		if (row != -1) {
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá khách hàng này không?", "Chú ý",
					JOptionPane.YES_NO_OPTION);
			if (hoiNhac == JOptionPane.YES_OPTION) {
				String ma = (String) table.getValueAt(row, 0);
				if (khDao.delete(ma)) {
					dataModel.removeRow(row);
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				} else
					JOptionPane.showMessageDialog(this, "Xoá thất bại!");
			}
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn khách hàng!");

	}

	private void capNhat() {
		int row = table.getSelectedRow();
		if (row != -1) {
			KhachHang kh = reverKHFromTextFile();
			if (khDao.update(kh)) {
				table.setValueAt(txtMaKhachHang.getText(), row, 0);
				table.setValueAt(txtTenKhachHang.getText(), row, 1);
				table.setValueAt(txtSDTKH.getText(), row, 2);
				table.setValueAt(txtEmail.getText(), row, 3);
				JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
			} else
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
		} else
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn khách hàng!");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaKhachHang.setText(table.getValueAt(row, 0).toString());
		txtTenKhachHang.setText(table.getValueAt(row, 1).toString());
		txtSDTKH.setText(table.getValueAt(row, 2).toString());
		txtEmail.setText(table.getValueAt(row, 3).toString());
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