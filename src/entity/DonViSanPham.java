package entity;

public class DonViSanPham {
	private String tenDonVi;

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public DonViSanPham() {

	}

	public DonViSanPham(String tenDonVi) {

		this.tenDonVi = tenDonVi;
	}

	@Override
	public String toString() {
		return "DonViSanPham [tenDonVi=" + tenDonVi + "]";
	}

}
