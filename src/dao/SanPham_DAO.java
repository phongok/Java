package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import entity.DonViSanPham;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.SanPham;

public class SanPham_DAO {
	private ArrayList<SanPham> dssp;

	public SanPham_DAO() {
		dssp = new ArrayList<SanPham>();
	}

	public List<SanPham> docDatabase() {
		try {
			Connection con = Database.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from SanPham");
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				String tenLSP = rs.getString(3);
				String donviSP = rs.getString(4);
				Double donGia = rs.getDouble(5);
				int slcon = rs.getInt(6);
				String tenNCC = rs.getString(7);
				String hinh = rs.getString(8);
				SanPham sp = new SanPham(maSP, tenSP, new LoaiSanPham(tenLSP), new DonViSanPham(donviSP), donGia, slcon, new NhaCungCap(tenNCC), hinh);
				dssp.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssp;
	}
	
	public boolean create(SanPham sp) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into SanPham values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, sp.getMaSanPham());
			stmt.setString(2, sp.getTenSanPham());
			stmt.setString(3, sp.getDvSP().getTenDonVi());
			stmt.setString(4, sp.getDvSP().getTenDonVi());
			stmt.setDouble(5, sp.getDonGia());
			stmt.setInt(6, sp.getSoLuongCon());
			stmt.setString(7, sp.getTenNCC().getTenNhaCungCap());
			stmt.setString(8, sp.getAnh());
			n=stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
}
