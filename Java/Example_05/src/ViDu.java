import java.util.Scanner;

public class ViDu {
	public static void main(String arg[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số nguyên n: ");
		n = sc.nextInt();
		
		if(n%2==0) {
			System.out.println(n + " Số chẵn");
		}
		else {
			System.out.println(n + " Số lẽ");
		}
	}
}
