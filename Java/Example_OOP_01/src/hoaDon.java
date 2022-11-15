
public class hoaDon {
	private String nameCafe;
	private double khoiLuong;
	private double giaTien;
	
	public hoaDon(String name, double khoiLuong, double giaTien) {
		this.nameCafe = name;
		this.khoiLuong = khoiLuong;
		this.giaTien = giaTien;
	}
	public double thanhTien() {
		 return this.khoiLuong*this.giaTien;
	}
}
