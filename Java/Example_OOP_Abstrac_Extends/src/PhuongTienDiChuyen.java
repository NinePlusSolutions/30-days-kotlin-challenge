
public abstract class PhuongTienDiChuyen {
	private String phuongTienDiChuyen;
	protected HangSanXuat hangSanXuat;

	public PhuongTienDiChuyen(String phuongTienDiChuyen, HangSanXuat hangSanXuat) {
		this.phuongTienDiChuyen = phuongTienDiChuyen;
		this.hangSanXuat = hangSanXuat;
	}

	public String getPhuongTienDiChuyen() {
		return phuongTienDiChuyen;
	}

	public void setPhuongTienDiChuyen(String phuongTienDiChuyen) {
		this.phuongTienDiChuyen = phuongTienDiChuyen;
	}
	
	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	
	public String LayTenHangSanXuat() {
		return this.hangSanXuat.getTenHangSX();
	}
	
	public void KhoiDong() {
		System.out.println("Khởi động......");
	}
	
	public void TangToc() {
		System.out.println("Tăng tốc.......");
	}
	public void TatMay() {
		System.out.println("Tắt máy.......");
	}
	
	public abstract double LayVanToc();
}
