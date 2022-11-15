import java.util.Scanner;

public class ViDu {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập a  = ");
		int a = sc.nextInt();
		
		String ketQua = (a%2==0) ? "Số chẵn" : "Số lẽ";
		System.out.println(ketQua);
	}
}
