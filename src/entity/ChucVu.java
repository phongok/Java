package entity;

public class ChucVu {
	private String tenChucVu;

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public ChucVu() {

	}

	public ChucVu(String tenChucVu) {
		
		this.tenChucVu = tenChucVu;
	}

	@Override
	public String toString() {
		return "ChucVu [tenChucVu=" + tenChucVu + "]";
	}

}
