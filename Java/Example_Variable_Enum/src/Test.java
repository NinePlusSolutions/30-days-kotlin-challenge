
public class Test {
	public static void main(String[] args) {
		ThoiKhoaBieu tkb = new ThoiKhoaBieu(Day.Sunday,"Toán, Lý, Hoá");
		ThoiKhoaBieu tkb1 = new ThoiKhoaBieu(Day.Thursday,"Văn, Sử , Địa");
		ThoiKhoaBieu tkb2 = new ThoiKhoaBieu(Day.TuesDay,"Anh, Lý, Văn");
		ThoiKhoaBieu tkb3 = new ThoiKhoaBieu(Day.Wednesday,"lý, Địa, Toán");
		ThoiKhoaBieu tkb4 = new ThoiKhoaBieu(Day.Friday,"Toán");
		ThoiKhoaBieu tkb5 = new ThoiKhoaBieu(Day.Saturday,"Toán");
		
		int x = Thang.thang1.getSoNgay();
		System.out.println("Tháng 1: " + x +" ngày");
		System.out.println(" " + tkb);
	}	
}
