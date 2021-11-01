package entity;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private LoaiSanPham tenloaiSP;
	private DonViSanPham dvSP;
	private double donGia;
	private int soLuongCon;
	private NhaCungCap tenNCC;
	private String anh;

	/**
	 * @return the maSanPham
	 */
	public String getMaSanPham() {
		return maSanPham;
	}

	/**
	 * @param maSanPham the maSanPham to set
	 */
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	/**
	 * @return the tenSanPham
	 */
	public String getTenSanPham() {
		return tenSanPham;
	}

	/**
	 * @param tenSanPham the tenSanPham to set
	 */
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	/**
	 * @return the tenloaiSP
	 */
	public LoaiSanPham getTenloaiSP() {
		return tenloaiSP;
	}

	/**
	 * @param tenloaiSP the tenloaiSP to set
	 */
	public void setTenloaiSP(LoaiSanPham tenloaiSP) {
		this.tenloaiSP = tenloaiSP;
	}

	/**
	 * @return the dvSP
	 */
	public DonViSanPham getDvSP() {
		return dvSP;
	}

	/**
	 * @param dvSP the dvSP to set
	 */
	public void setDvSP(DonViSanPham dvSP) {
		this.dvSP = dvSP;
	}

	/**
	 * @return the donGia
	 */
	public double getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	/**
	 * @return the soLuongCon
	 */
	public int getSoLuongCon() {
		return soLuongCon;
	}

	/**
	 * @param soLuongCon the soLuongCon to set
	 */
	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}

	/**
	 * @return the tenNCC
	 */
	public NhaCungCap getTenNCC() {
		return tenNCC;
	}

	/**
	 * @param tenNCC the tenNCC to set
	 */
	public void setTenNCC(NhaCungCap tenNCC) {
		this.tenNCC = tenNCC;
	}

	/**
	 * @return the anh
	 */
	public String getAnh() {
		return anh;
	}

	/**
	 * @param anh the anh to set
	 */
	public void setAnh(String anh) {
		this.anh = anh;
	}

	/**
	 * @param dir 
	 * @param i 
	 * @param d 
	 * @param string4 
	 * @param string3 
	 * @param string2 
	 * @param string 
	 * 
	 */
	public SanPham(String string, String string2, String string3, String string4, double d, int i, String dir) {
	}

	/**
	 * @param maSanPham
	 * @param tenSanPham
	 * @param tenloaiSP
	 * @param dvSP
	 * @param donGia
	 * @param soLuongCon
	 * @param tenNCC
	 * @param anh
	 */
	public SanPham(String maSanPham, String tenSanPham, LoaiSanPham tenloaiSP, DonViSanPham dvSP, double donGia,
			int soLuongCon, NhaCungCap tenNCC, String anh) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tenloaiSP = tenloaiSP;
		this.dvSP = dvSP;
		this.donGia = donGia;
		this.soLuongCon = soLuongCon;
		this.tenNCC = tenNCC;
		this.anh = anh;
	}

	/**
	 * @param maSanPham
	 */
	public SanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", tenloaiSP=" + tenloaiSP + ", dvSP="
				+ dvSP + ", donGia=" + donGia + ", soLuongCon=" + soLuongCon + ", tenNCC=" + tenNCC + ", anh=" + anh
				+ "]";
	}

}