package entity;

public class TaiKhoan {
	private NhanVien maTaiKhoan;
	private String tenDN;
	private String loaiTaiKhoan;
	private String matKhau;
	/**
	 * @return the maTaiKhoan
	 */
	public NhanVien getMaTaiKhoan() {
		return maTaiKhoan;
	}
	/**
	 * @param maTaiKhoan the maTaiKhoan to set
	 */
	public void setMaTaiKhoan(NhanVien maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	/**
	 * @return the tenDN
	 */
	public String gettenDN() {
		return tenDN;
	}
	/**
	 * @param tenDN the tenDN to set
	 */
	public void settenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	/**
	 * @return the loaiTaiKhoan
	 */
	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}
	/**
	 * @param loaiTaiKhoan the loaiTaiKhoan to set
	 */
	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}
	/**
	 * @return the matKhau
	 */
	public String getMatKhau() {
		return matKhau;
	}
	/**
	 * @param matKhau the matKhau to set
	 */
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	/**
	 * 
	 */
	public TaiKhoan() {
	}
	/**
	 * @param maTaiKhoan
	 * @param tenDN
	 * @param loaiTaiKhoan
	 * @param matKhau
	 */
	public TaiKhoan(NhanVien maTaiKhoan, String tenDN, String loaiTaiKhoan, String matKhau) {
		this.maTaiKhoan = maTaiKhoan;
		this.tenDN = tenDN;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", tenDN=" + tenDN + ", loaiTaiKhoan=" + loaiTaiKhoan
				+ ", matKhau=" + matKhau + "]";
	}
	
}
