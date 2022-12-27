import java.util.Scanner;

public class BaiTap {
	public static void main(String arg[]) {
		int thang, nam;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tháng: ");
		thang = sc.nextInt();
		System.out.println("Nhập năm: ");
		nam = sc.nextInt();
		switch (thang) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			System.out.println("Tháng có 31 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng có 30 ngày");
			break;
		case 2:
			if((nam%4 == 0 && nam%100 != 0) || (nam%400 == 0)) {
				System.out.println("có 29 ngày");
			}else {
				System.out.println("có 28 ngày");
			}
			break;
		default:
			System.out.println("Nhập dữ liệu sai");
			break;
		}
	}
}
