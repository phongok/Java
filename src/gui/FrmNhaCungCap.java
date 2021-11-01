package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.Database;
import dao.NhaCungCap_DAO;
import entity.NhaCungCap;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class FrmNhaCungCap extends JFrame implements ActionListener, MouseListener {

	private JPanel pnlPane;
	private JTextField txtTenNhaCC;
	private JTextField txtDiaChiNCC;
	private JTextField txtSDTNCC;
	private JTextField txtSoFax;
	private JTextField txtEmailNCC;
	private JTextField txtWeb;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private JButton btnThoat;
	private JButton btnQuayLai;
	private NhaCungCap_DAO nccDao = new NhaCungCap_DAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhaCungCap frame = new FrmNhaCungCap();
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
	public FrmNhaCungCap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 814, 584);
		pnlPane = new JPanel();
		pnlPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPane);
		pnlPane.setLayout(null);

		JPanel spr1 = new JPanel();
		spr1.setBackground(Color.LIGHT_GRAY);
		spr1.setBounds(0, 0, 822, 562);
		pnlPane.add(spr1);
		spr1.setLayout(null);

		JLabel lblTieuDe = new JLabel("TH\u00CAM TH\u00D4NG TIN NH\u00C0 CUNG C\u1EA4P");
		lblTieuDe.setForeground(Color.RED);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblTieuDe.setBounds(138, 10, 614, 41);
		spr1.add(lblTieuDe);

		JLabel lblTenNhaCungCap = new JLabel("T\u00EAn nh\u00E0 cung c\u1EA5p");
		lblTenNhaCungCap.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblTenNhaCungCap.setBounds(25, 61, 192, 50);
		spr1.add(lblTenNhaCungCap);

		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblDiaChi.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblDiaChi.setBounds(25, 121, 192, 50);
		spr1.add(lblDiaChi);

		JLabel lblSDTNCC = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSDTNCC.setIcon(
				new ImageIcon("C:\\Users\\ASUS\\Desktop\\z2803426554258_bd4e0dacf3069a95e014d050b453591e.jpg"));
		lblSDTNCC.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblSDTNCC.setBounds(25, 181, 192, 50);
		spr1.add(lblSDTNCC);

		JLabel lblSoFax = new JLabel("S\u1ED1 FAX");
		lblSoFax.setIcon(
				new ImageIcon("C:\\Users\\ASUS\\Desktop\\z2803430291533_b98df878001bff6c41f6469ed93e352b.jpg"));
		lblSoFax.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblSoFax.setBounds(25, 241, 192, 50);
		spr1.add(lblSoFax);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setIcon(
				new ImageIcon("C:\\Users\\ASUS\\Desktop\\z2803432078287_45ce0f215caa6e4e12b16c6c1412b604.jpg"));
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblEmail.setBounds(25, 301, 192, 50);
		spr1.add(lblEmail);

		JLabel lblWeb = new JLabel("Website");
		lblWeb.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\z2803433543063_93fa85d4f626d11d8778a0640194943d.jpg"));
		lblWeb.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblWeb.setBounds(25, 361, 192, 50);
		spr1.add(lblWeb);

		txtTenNhaCC = new JTextField();
		txtTenNhaCC.setHorizontalAlignment(SwingConstants.LEFT);
		txtTenNhaCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenNhaCC.setBounds(227, 73, 512, 30);
		spr1.add(txtTenNhaCC);
		txtTenNhaCC.setColumns(10);

		txtDiaChiNCC = new JTextField();
		txtDiaChiNCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtDiaChiNCC.setHorizontalAlignment(SwingConstants.LEFT);
		txtDiaChiNCC.setBounds(227, 136, 512, 30);
		spr1.add(txtDiaChiNCC);
		txtDiaChiNCC.setColumns(10);

		txtSDTNCC = new JTextField();
		txtSDTNCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDTNCC.setHorizontalAlignment(SwingConstants.LEFT);
		txtSDTNCC.setBounds(227, 195, 512, 30);
		spr1.add(txtSDTNCC);
		txtSDTNCC.setColumns(10);

		txtSoFax = new JTextField();
		txtSoFax.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoFax.setHorizontalAlignment(SwingConstants.LEFT);
		txtSoFax.setBounds(227, 255, 512, 30);
		spr1.add(txtSoFax);
		txtSoFax.setColumns(10);

		txtEmailNCC = new JTextField();
		txtEmailNCC.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmailNCC.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmailNCC.setBounds(227, 310, 512, 30);
		spr1.add(txtEmailNCC);
		txtEmailNCC.setColumns(10);

		txtWeb = new JTextField();
		txtWeb.setHorizontalAlignment(SwingConstants.LEFT);
		txtWeb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtWeb.setBounds(227, 370, 512, 30);
		spr1.add(txtWeb);
		txtWeb.setColumns(10);

		btnLuu = new JButton("L\u01AFU");
		btnLuu.setBackground(new Color(153, 204, 255));
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLuu.setForeground(Color.RED);
		btnLuu.setBounds(272, 410, 100, 34);
		spr1.add(btnLuu);

		btnXoaTrang = new JButton("X\u00D3A TR\u1EAENG");
		btnXoaTrang.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXoaTrang.setForeground(Color.RED);
		btnXoaTrang.setBounds(395, 410, 153, 34);
		spr1.add(btnXoaTrang);

		btnThoat = new JButton("THO\u00C1T");
		btnThoat.setBackground(new Color(255, 153, 51));
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBounds(624, 488, 105, 30);
		spr1.add(btnThoat);

		btnQuayLai = new JButton("QUAY L\u1EA0I");
		btnQuayLai.setBackground(new Color(255, 204, 51));
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuayLai.setForeground(Color.RED);
		btnQuayLai.setBounds(429, 488, 142, 30);
		spr1.add(btnQuayLai);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 474, 684, 2);
		spr1.add(separator);

		btnLuu.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnQuayLai.addActionListener(this);
		btnThoat.addActionListener(this);
		Database.getInstance().connect();
	}
	private void xoaRongTextfields() {
		txtTenNhaCC.setText("");
		txtDiaChiNCC.setText("");
		txtSDTNCC.setText("");
		txtSoFax.setText("");
		txtEmailNCC.setText("");
		txtWeb.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLuu)) {
			NhaCungCap ncc = new NhaCungCap(txtTenNhaCC.getText(), txtDiaChiNCC.getText(), txtSDTNCC.getText(),
					txtSoFax.getText(), txtEmailNCC.getText(), txtWeb.getText());
			if (valibData() == true) {
				if (nccDao.create(ncc)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm thất bại công!");
				}
			} 
			
		}
		else if (o.equals(btnXoaTrang)) {
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
	public boolean valibData() {
		String tenNCC = txtTenNhaCC.getText().trim();
		String diaChiNCC = txtDiaChiNCC.getText().trim();
		String sdtNCC = txtSDTNCC.getText().trim();
		String soFaxNCC = txtSoFax.getText().trim();
		String emailNCC = txtEmailNCC.getText().trim();
		String websiteNCC = txtWeb.getText().trim();
		
		if (tenNCC.length()<=0) {
			JOptionPane.showMessageDialog(this, "Tên nhà cung cấp khác rỗng, không chứa ký tự đặc biệt" );
		     txtTenNhaCC.requestFocus();
		     return false;
		}
		if (diaChiNCC.length()<=0) {
			JOptionPane.showMessageDialog(this, "Địa chỉ nhà cung cấp khác rỗng, không chứa ký tự đặc biệt" );
		     txtDiaChiNCC.requestFocus();
		     return false;
		}
		if (sdtNCC.length()<=0) {
			JOptionPane.showMessageDialog(this, "Số điện thoại nhà cung cấp khác rỗng, không chứa ký tự đặc biệt" );
		     txtSDTNCC.requestFocus();
		     return false;
		}
		if (soFaxNCC.length()<=0) {
			JOptionPane.showMessageDialog(this, "Số fax nhà cung cấp khác rỗng, không chứa ký tự đặc biệt" );
		     txtSoFax.requestFocus();
		     return false;
		}
		if (emailNCC.length()<=0) {
			JOptionPane.showMessageDialog(this, "Email nhà cung cấp khác rỗng, không chứa ký tự đặc biệt" );
		     txtEmailNCC.requestFocus();
		     return false;
		}
		if (websiteNCC.length()<=0) {
			JOptionPane.showMessageDialog(this, "Website nhà cung cấp khác rỗng, không chứa ký tự đặc biệt" );
		     txtWeb.requestFocus();
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
