
public class Main {
	public static void main(String[] args) {
		HangSanXuat h1 = new HangSanXuat("Hãng 1", "Việt Nam");
		HangSanXuat h2 = new HangSanXuat("Hãng 2", "Korea");
		HangSanXuat h3 = new HangSanXuat("Hãng 3", "Japan");
		
		PhuongTienDiChuyen p1 = new MayBay("Xăng",h1);
		PhuongTienDiChuyen p2 = new XeOto("Trường Hải",h2);
		PhuongTienDiChuyen p3 = new XeDap(h3);
		
		System.out.println("Lấy hãng sản xuất xeOto: " + p1.LayTenHangSanXuat());
		System.out.println("Vận tốc XeOto: " + p2.LayVanToc());
		System.out.println("Vận tốc Máy Bay: " + p1.LayVanToc());
		System.out.println("Vận tốc XeDap: " + p3.LayVanToc());
		
		
	}
}
