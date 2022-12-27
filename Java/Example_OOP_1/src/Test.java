
public class Test {
	public static void main(String arg[]) {
		hoaDonCafe hd = new hoaDonCafe("Cafe Trung Nguyên", 4, 200);
		System.out.println("Tổng tiền: " + hd.thanhTien());
		System.out.println("Kiểm tra khối lượng < 2: " + hd.kiemTra(5));
		System.out.println("Kiểm tra tổng tiền > 500: " + hd.kiemTraTien());
		System.out.println("Giảm giá: " + hd.disCount(10));
		System.out.println("Số tiền sau khi giảm giá: " + hd.soTienSauKhiGiamGia(10));
	}
}
