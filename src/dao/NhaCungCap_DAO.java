package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import entity.KhachHang;
import entity.NhaCungCap;

public class NhaCungCap_DAO {
	ArrayList<NhaCungCap> dsncc;

	public NhaCungCap_DAO() {
		dsncc = new ArrayList<NhaCungCap>();
	}
	public void xoaHetDanhSach() {
		dsncc.clear();
	}
	public List<NhaCungCap> docDatabase() {
		try {
			Connection con = Database.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from NhaCungCap");
			while (rs.next()) {
				String tenNCC = rs.getString(1);
				String diaChi = rs.getString(2);
				String sdtNCC = rs.getString(3);
				String soFax = rs.getString(4);
				String emailNCC = rs.getString(5);
				String website = rs.getString(6);
				NhaCungCap ncc = new NhaCungCap(tenNCC, diaChi, sdtNCC, soFax, emailNCC, website);
				dsncc.add(ncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsncc;
	}
	
	public boolean create(NhaCungCap nhaCungCap) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhaCungCap values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nhaCungCap.getTenNhaCungCap());
			stmt.setString(2, nhaCungCap.getDiaChi());
			stmt.setString(3, nhaCungCap.getSdtNCC());
			stmt.setString(4, nhaCungCap.getSoFax());
			stmt.setString(5, nhaCungCap.getEmail());
			stmt.setString(6, nhaCungCap.getWebSite());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public NhaCungCap getNhaCungCapTheoSoDienThoai(String sdtTim) {
		NhaCungCap ncc = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhaCungCap where sdtNCC = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, sdtTim);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String tenNCC = rs.getString(1);
				String diaChi = rs.getString(2);
				String sdtNCC = rs.getString(3);
				String soFax = rs.getString(4);
				String emailNCC = rs.getString(5);
				String website = rs.getString(6);
				ncc = new NhaCungCap(tenNCC, diaChi, sdtNCC, soFax, emailNCC, website);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc;
	}
	
	public NhaCungCap getNhaCungCapTheoSoFax(String soFaxTim) {
		NhaCungCap ncc = null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhaCungCap where soFax = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, soFaxTim);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String tenNCC = rs.getString(1);
				String diaChi = rs.getString(2);
				String sdtNCC = rs.getString(3);
				String soFax = rs.getString(4);
				String emailNCC = rs.getString(5);
				String website = rs.getString(6);
				ncc = new NhaCungCap(tenNCC, diaChi, sdtNCC, soFax, emailNCC, website);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ncc;
	}
	
	public boolean update(NhaCungCap ncc) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("update NhaCungCap set diaChi=?, sdtNCC =?, soFax=?, emailNCC=?, webSite=? where tenNhaCungCap=?");
			
			stmt.setString(1, ncc.getDiaChi());
			stmt.setString(2, ncc.getSdtNCC());
			stmt.setString(3, ncc.getSoFax());
			stmt.setString(4, ncc.getEmail());
			stmt.setString(5, ncc.getWebSite());
			stmt.setString(6, ncc.getTenNhaCungCap());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean delete(String tenNCC) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaCungCap where tenNhaCungCap = ?");
			stmt.setString(1, tenNCC);
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
