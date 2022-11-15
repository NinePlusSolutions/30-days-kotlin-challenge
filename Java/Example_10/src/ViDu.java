import java.util.Scanner;

public class ViDu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		try {
			System.out.println("Nhập vào số nguyên n: ");
			n  = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Lỗi nhập dữ liệu");
		} finally {
			System.out.println("Giá trị nhập là: " + n);
			System.out.println("Chương trìn kết thúc");
		}
	}
}
