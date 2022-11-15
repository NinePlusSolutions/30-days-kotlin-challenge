import java.util.Scanner;

public class ViDu {
	public static void main(String arg[]) {
		int a,b;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextInt();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextInt();
	    int	tong = a + b;
	    System.out.println("Tổng: "+tong);
	}
}
