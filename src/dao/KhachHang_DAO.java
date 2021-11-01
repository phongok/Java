package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectDB.Database;
import entity.KhachHang;

public class KhachHang_DAO {
	ArrayList<KhachHang> dskh;

	public KhachHang_DAO() {
		dskh = new ArrayList<KhachHang>();
	}

	public void xoaHetDanhSach() {
		dskh.clear();
	}

	public List<KhachHang> docDatabase() {
		try {
			Connection con = Database.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from KhachHang");
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				KhachHang kh = new KhachHang(maKH, tenKH, sdt, email);
				dskh.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;
	}

	public boolean create(KhachHang khachhang) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into KhachHang values(?, ?, ?, ?)");
			stmt.setString(1, khachhang.getMaKH());
			stmt.setString(2, khachhang.getTenKH());
			stmt.setString(3, khachhang.getSdt());
			stmt.setString(4, khachhang.getEmail());

			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public KhachHang getKhachHangTheoMaKhachHang(String maKH) {
		KhachHang kh = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from KhachHang where maKhachHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				kh = new KhachHang(ma, ten, sdt, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
	public KhachHang getKhachHangTheoTen(String tenKH) {
		KhachHang kh = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from KhachHang where tenKhachHang = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenKH);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				kh = new KhachHang(ma, ten, sdt, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
	
	public KhachHang getKhachHangTheoSoDienThoai(String sdtKH) {
		KhachHang kh = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from KhachHang where sdtKH = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sdtKH);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				String sdt = rs.getString(3);
				String email = rs.getString(4);
				kh = new KhachHang(ma, ten, sdt, email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}

	public boolean update(KhachHang kh) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update KhachHang set tenKhachHang=?, sdtKH=?, email =? where maKhachHang=?");
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getSdt());
			stmt.setString(3, kh.getEmail());
			stmt.setString(4, kh.getMaKH());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(String maKH) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where maKhachHang = ?");
			stmt.setString(1, maKH);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}