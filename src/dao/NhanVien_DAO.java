package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import connectDB.Database;
import entity.KhachHang;
import entity.NhanVien;
import entity.TaiKhoan;

public class NhanVien_DAO {
	private List<NhanVien> dsnv;

	public NhanVien_DAO() {
		dsnv = new ArrayList<NhanVien>();
	}

	public List<NhanVien> docDatabase() {
		try {
			Connection con = Database.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from NhanVien");
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				boolean gioiTinh = rs.getBoolean(4);
				String soCMND = rs.getString(5);
				String chucVu = rs.getString(6);
				String hinh = rs.getString(7);
				String diaChi = rs.getString(8);
				String sdt = rs.getString(9);
				String email = rs.getString(10);
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, soCMND, chucVu, hinh, diaChi, sdt, email);
				dsnv.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}

	public boolean luu(NhanVien nv) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setDate(3, Date.valueOf(nv.getNgaySinh()));
			stmt.setBoolean(4, nv.isGioiTinh());
			stmt.setString(5, nv.getSoCMND());
			stmt.setString(6, nv.getTenChucVu());
			stmt.setString(7, nv.getHinh());
			stmt.setString(8, nv.getDiaChi());
			stmt.setString(9, nv.getSdtNhanVien());
			stmt.setString(10, nv.getEmail());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean xoa(String maNV) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNhanVien = ?");
			stmt.setString(1, maNV);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean capNhat(NhanVien nv) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set tenNhanVien=?, ngaySinh=?, gioiTinh =?, soCMND=?, "
					+ "tenChucVu=?, hinh=?, diaChi=?, sdtNV=?, email=? where maNhanVien=?");
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setDate(2, Date.valueOf(nv.getNgaySinh()));
			stmt.setBoolean(3, nv.isGioiTinh());
			stmt.setString(4, nv.getSoCMND());
			stmt.setString(5, nv.getTenChucVu());
			stmt.setString(6, nv.getHinh());
			stmt.setString(7, nv.getDiaChi());
			stmt.setString(8, nv.getSdtNhanVien());
			stmt.setString(9, nv.getEmail());
			stmt.setString(10, nv.getMaNhanVien());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public NhanVien TimTheoMa(String maNV) {
		NhanVien nv = null;

		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien where maNhanVien = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String maNhanVien = rs.getString(1);
				String tenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				boolean gioiTinh = rs.getBoolean(4);
				String soCMND = rs.getString(5);
				String chucVu = rs.getString(6);
				String hinh = rs.getString(7);
				String diaChi = rs.getString(8);
				String sdtNV = rs.getString(9);
				String emailNV = rs.getString(10);
				nv = new NhanVien(maNhanVien, tenNV, ngaySinh, gioiTinh, soCMND, chucVu, hinh, diaChi, sdtNV, emailNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public NhanVien getNhanVienTheoMa(String maNV) {
		NhanVien nv = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien where maNhanVien = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String maNhanVien = rs.getString(1);
				String tenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				boolean gioiTinh = rs.getBoolean(4);
				String soCMND = rs.getString(5);
				String chucVu = rs.getString(6);
				String hinh = rs.getString(7);
				String diaChi = rs.getString(8);
				String sdtNV = rs.getString(9);
				String emailNV = rs.getString(10);
				nv = new NhanVien(maNhanVien, tenNV, ngaySinh, gioiTinh, soCMND, chucVu, hinh, diaChi, sdtNV, emailNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	
	public NhanVien getNhanVienTheoCMND(String cmndNV) {
		NhanVien nv = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien where soCMND = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cmndNV);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String maNhanVien = rs.getString(1);
				String tenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				boolean gioiTinh = rs.getBoolean(4);
				String soCMND = rs.getString(5);
				String chucVu = rs.getString(6);
				String hinh = rs.getString(7);
				String diaChi = rs.getString(8);
				String sdtNV = rs.getString(9);
				String emailNV = rs.getString(10);
				nv = new NhanVien(maNhanVien, tenNV, ngaySinh, gioiTinh, soCMND, chucVu, hinh, diaChi, sdtNV, emailNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public NhanVien getNhanVienTheoSDT(String sdt) {
		NhanVien nv = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien where sdtNV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sdt);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String maNhanVien = rs.getString(1);
				String tenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				boolean gioiTinh = rs.getBoolean(4);
				String soCMND = rs.getString(5);
				String chucVu = rs.getString(6);
				String hinh = rs.getString(7);
				String diaChi = rs.getString(8);
				String sdtNV = rs.getString(9);
				String emailNV = rs.getString(10);
				nv = new NhanVien(maNhanVien, tenNV, ngaySinh, gioiTinh, soCMND, chucVu, hinh, diaChi, sdtNV, emailNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
	
	public void getThongTin(String tenDangNhap, JTextField txt1, JTextField txt2, JTextField txt3, JRadioButton txt40,
			JRadioButton txt41, JTextField txt5, JTextField txt6, JTextField txt7, JTextField txt8, JTextField txt9,
			JLabel txt10) {
		NhanVien nv = null;

		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien where soCMND = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String maNhanVien = rs.getString(1);
				String tenNV = rs.getString(2);
				LocalDate ngaySinh = rs.getDate(3).toLocalDate();
				boolean gioiTinh = rs.getBoolean(4);
				String soCMND = rs.getString(5);
				String chucVu = rs.getString(6);
				String hinh = rs.getString(7);
				String diaChi = rs.getString(8);
				String sdtNV = rs.getString(9);
				String emailNV = rs.getString(10);
				nv = new NhanVien(maNhanVien, tenNV, ngaySinh, gioiTinh, soCMND, chucVu, hinh, diaChi, sdtNV, emailNV);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		txt1.setText(nv.getMaNhanVien());
		txt2.setText(nv.getTenNhanVien());
		txt3.setText(nv.getNgaySinh().toString());
		if (nv.isGioiTinh() == true) {
			txt40.setSelected(true);
		} else {
			txt41.setSelected(false);
		}
		txt5.setText(nv.getSoCMND());
		txt6.setText(nv.getTenChucVu());
		txt10.setIcon(new ImageIcon(nv.getHinh()));
		txt7.setText(nv.getDiaChi());
		txt8.setText(nv.getSdtNhanVien());
		txt9.setText(nv.getEmail());

	}
}
