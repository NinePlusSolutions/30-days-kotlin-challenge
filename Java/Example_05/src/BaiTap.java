import java.util.Scanner;

public class BaiTap {
	public static void main(String arg[]) {
		double a,b,x;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = sc.nextDouble();
		System.out.println("Nhập b: ");
		b = sc.nextDouble();
		
		if(a == 0) {
			if(b == 0) {
				System.out.println("PT vô số nghiệm");
			}
			else {
				System.out.println("PT vô nghiệm");
			}
		}
		else {
			x = -b/a;
			System.out.println("PT có nghiệm là: " + x);
		}
	}
}
