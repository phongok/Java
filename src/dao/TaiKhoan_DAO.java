package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	private List<TaiKhoan> dstk;
	
	public TaiKhoan_DAO() {
		dstk=new ArrayList<TaiKhoan>();
	}
	
	public boolean create(TaiKhoan tk) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into TaiKhoan values(?,?,?,?)");		
			stmt.setString(1, tk.getMaTaiKhoan().getMaNhanVien());
			stmt.setString(2, tk.gettenDN());
			stmt.setString(3, tk.getLoaiTaiKhoan());
			stmt.setString(4, tk.getMatKhau());
			n=stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public boolean delete(String maTK) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where maTaiKhoan = ?");
			stmt.setString(1, maTK) ;
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public TaiKhoan getTaiKhoan(String tenDangNhap) {
		TaiKhoan taiKhoan=null;
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from TaiKhoan where tenDangNhap = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenDangNhap);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String maTaiKhoan = rs.getString(1);
				String tenDN = rs.getString(2);
				String loaiTaiKhoan = rs.getString(3);
				String matKhau = rs.getString(4);
				taiKhoan=new TaiKhoan(new NhanVien(maTaiKhoan), tenDN, loaiTaiKhoan, matKhau);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taiKhoan;
	}
	
	
	
}
