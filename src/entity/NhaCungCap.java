package entity;

public class NhaCungCap {
	private String tenNhaCungCap;
	private String diaChi;
	private String sdtNCC;
	private String soFax;
	private String email;
	private String webSite;
	/**
	 * @return the tenNhaCungCap
	 */
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	/**
	 * @param tenNhaCungCap the tenNhaCungCap to set
	 */
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}
	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	/**
	 * @return the sdtNCC
	 */
	public String getSdtNCC() {
		return sdtNCC;
	}
	/**
	 * @param sdtNCC the sdtNCC to set
	 */
	public void setSdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}
	/**
	 * @return the soFax
	 */
	public String getSoFax() {
		return soFax;
	}
	/**
	 * @param soFax the soFax to set
	 */
	public void setSoFax(String soFax) {
		this.soFax = soFax;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the webSite
	 */
	public String getWebSite() {
		return webSite;
	}
	/**
	 * @param webSite the webSite to set
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	/**
	 * 
	 */
	public NhaCungCap() {
	}
	/**
	 * @param tenNhaCungCap
	 * @param diaChi
	 * @param sdtNCC
	 * @param soFax
	 * @param email
	 * @param webSite
	 */
	
	
	public NhaCungCap(String tenNhaCungCap, String diaChi, String sdtNCC, String soFax, String email, String webSite) {
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.sdtNCC = sdtNCC;
		this.soFax = soFax;
		this.email = email;
		this.webSite = webSite;
	}
	/**
	 * @param tenNhaCungCap
	 */
	public NhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	

	
	

}
