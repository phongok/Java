package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class FrmQuanLiSanPham extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLiSanPham frame = new FrmQuanLiSanPham();
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
	public FrmQuanLiSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 0, 1500, 788);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 10, 1466, 458);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(926, 35, 512, 411);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tìm theo mã:");
		lblNewLabel_1.setBounds(40, 21, 124, 24);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tìm theo tên:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(40, 104, 124, 24);
		panel_1.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setToolTipText("*Bắt đầu bằng 2 chữ SP");
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(176, 18, 303, 30);
		panel_1.add(textField);

		textField_1 = new JTextField();
		textField_1.setToolTipText("*Bắt đầu bằng chữ cái in hoa");
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(176, 101, 303, 30);
		panel_1.add(textField_1);
		
		JButton btnNewButton_2 = new JButton("Tìm kiếm theo mã");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_2.setBounds(209, 61, 235, 30);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Tìm Theo Tên");
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_3.setBounds(209, 141, 235, 30);
		panel_1.add(btnNewButton_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(40, 271, 439, 2);
		panel_1.add(separator);
		
		JButton btnQuayLi = new JButton("QUAY LẠI");
		btnQuayLi.setForeground(Color.RED);
		btnQuayLi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuayLi.setBounds(189, 349, 151, 30);
		panel_1.add(btnQuayLi);
		
		JButton btnThot = new JButton("THOÁT");
		btnThot.setForeground(Color.RED);
		btnThot.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThot.setBounds(351, 349, 151, 30);
		panel_1.add(btnThot);
		
		JButton btnXa = new JButton("XÓA");
		btnXa.setForeground(Color.RED);
		btnXa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXa.setBounds(351, 307, 151, 30);
		panel_1.add(btnXa);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(28, 35, 512, 411);
		panel.add(panel_3);

		JLabel lblNewLabel_1_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(20, 10, 144, 24);
		panel_3.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_2_1.setBounds(20, 52, 144, 24);
		panel_3.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("Đơn giá:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_3_1.setBounds(20, 92, 144, 24);
		panel_3.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("Loại sản phẩm:");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_4_1.setBounds(20, 130, 144, 25);
		panel_3.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("Đơn vị:");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_5_1.setBounds(20, 179, 138, 24);
		panel_3.add(lblNewLabel_5_1);

		JLabel lblNewLabel_6_1 = new JLabel("Nhà cung cấp:");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_6_1.setBounds(17, 222, 147, 24);
		panel_3.add(lblNewLabel_6_1);

		textField_8 = new JTextField();
		textField_8.setToolTipText("*Bắt đầu bằng 2 chữ SP");
		textField_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_8.setColumns(10);
		textField_8.setBounds(176, 10, 303, 25);
		panel_3.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setToolTipText("*Bắt đầu bằng chữ cái in hoa");
		textField_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_9.setColumns(10);
		textField_9.setBounds(176, 49, 303, 30);
		panel_3.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_10.setColumns(10);
		textField_10.setBounds(176, 89, 303, 30);
		panel_3.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(176, 176, 303, 30);
		panel_3.add(textField_11);
		
				JButton btnNewButton = new JButton("CẬP NHẬT");
				btnNewButton.setForeground(Color.RED);
				btnNewButton.setBounds(176, 310, 151, 30);
				panel_3.add(btnNewButton);
				btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(176, 132, 303, 25);
				panel_3.add(comboBox);
				
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
				comboBox_1.setBounds(174, 219, 305, 30);
				panel_3.add(comboBox_1);

		JLabel lblNewLabel = new JLabel("QUẢN LÍ THÔNG TIN SẢN PHẨM");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(550, 0, 415, 39);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(582, 36, 308, 410);
		panel.add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(10, 478, 1466, 261);
		Box b6, b7;
		panel_4.add(b6 = Box.createHorizontalBox());
		panel_4.add(b7 = Box.createHorizontalBox());
		String[] headers = {"STT","Mã sản phẩm ", "Tên sản phẩm", "Đơn giá", "Loại sản phẩm", "Đơn vị", "Nhà cung cấp"};
		DefaultTableModel dataModel = new DefaultTableModel(headers , 0);
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
	}
}
