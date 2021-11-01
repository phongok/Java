package entity;

import java.time.LocalDate;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private String soCMND;
	private String tenChucVu;
	private String hinh;
	private String diaChi;
	private String sdtNhanVien;
	private String email;
	
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdtNhanVien() {
		return sdtNhanVien;
	}
	public void setSdtNhanVien(String sdtNhanVien) {
		this.sdtNhanVien = sdtNhanVien;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NhanVien() {
	}
	public NhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, LocalDate ngaySinh, boolean gioiTinh, String soCMND,
			String tenChucVu, String hinh, String diaChi, String sdtNhanVien, String email) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.tenChucVu = tenChucVu;
		this.hinh = hinh;
		this.diaChi = diaChi;
		this.sdtNhanVien = sdtNhanVien;
		this.email = email;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", soCMND=" + soCMND + ", tenChucVu=" + tenChucVu + ", diaChi=" + diaChi
				+ ", sdtNhanVien=" + sdtNhanVien + ", email=" + email + "]";
	}
}
