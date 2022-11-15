import java.util.Objects;

public class Book {
	private int namXuatBan;
	private double giaTien;
	private String tenSach;
	private Author tacGia;
	
	public Book(String tenSach, double giaTien, int namXuatBan,Author tacGia) {
		this.tenSach = tenSach;
		this.giaTien = giaTien;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
	}
	

	public int getNamXuatBan() {
		return namXuatBan;
	}


	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}


	public double getGiaTien() {
		return giaTien;
	}


	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}


	public String getTenSach() {
		return tenSach;
	}


	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}


	public Author getTacGia() {
		return tacGia;
	}


	public void setTacGia(Author tacGia) {
		this.tacGia = tacGia;
	}

	public void printBook() {
		System.out.println(this.tenSach);
	}
	
	public boolean kiemTraCungNXB(Book sachKhac) {
		return this.namXuatBan == sachKhac.namXuatBan;	
	}
	
	public double disCount(double x) {
		return this.giaTien*(1-x/100);
	}
	
	@Override
	public String toString() {
		return "Book [namXuatBan=" + namXuatBan + ", giaTien=" + giaTien + ", tenSach=" + tenSach + ", tacGia=" + tacGia
				+ "]";
	}
	
	
}
