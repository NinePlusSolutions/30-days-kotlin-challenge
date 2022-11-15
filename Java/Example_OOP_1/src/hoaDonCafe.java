
public class hoaDonCafe {
	public String ten;
	private double khoiLuong;
	private double giaTien;
	
	public hoaDonCafe(String ten, double khoiLuong, double giaTien) {
		this.ten = ten;
		this.khoiLuong = khoiLuong;
		this.giaTien = giaTien;
	}
	public boolean kiemTra(double kl) {
		return this.khoiLuong > kl;
	}
	public boolean kiemTraTien() {
		return this.thanhTien() > 500 ;
	}
	public double disCount(double x) {
		if(this.thanhTien() > 500) {
			return (x/100)*this.thanhTien();
		}else {
			return 0;
		}
	}
	public double soTienSauKhiGiamGia(double x) {
		return this.thanhTien() - this.disCount(x);
	}
	public double thanhTien() {
		 return this.khoiLuong*this.giaTien;
	}
}
