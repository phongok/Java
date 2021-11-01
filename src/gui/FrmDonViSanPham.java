package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;

public class FrmDonViSanPham extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDonViSanPham frame = new FrmDonViSanPham();
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
	public FrmDonViSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 278);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Đơn Vị Sản Phẩm");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(198, 0, 269, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Đơn Vị SP: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(26, 54, 160, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBounds(208, 54, 451, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
	JButton btnNewButton = new JButton("Lưu");
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(233, 123, 110, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Xóa Trắng");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBounds(378, 123, 158, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thoát");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(569, 185, 85, 30);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Quay Lại");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBounds(413, 185, 120, 30);
		contentPane.add(btnNewButton_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 173, 633, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("*Chữ cái đầu nhập in hoa");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(207, 91, 370, 13);
		contentPane.add(lblNewLabel_2);
	}
}
