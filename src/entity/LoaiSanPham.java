package entity;

public class LoaiSanPham {
	private String tenLoaiSanPham;

	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public LoaiSanPham() {

	}

	public LoaiSanPham(String tenLoaiSanPham) {

		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	@Override
	public String toString() {
		return "LoaiSanPham [tenLoaiSanPham=" + tenLoaiSanPham + "]";
	}

}
