import java.util.Scanner;

public class GiaiThua {

	public static long tinhGiaiThua(int n) {
		if(n > 0) {
			return  n * tinhGiaiThua(n-1);
		}else {
			return 1;
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập giá trị từ bàn phím: ");
		n = sc.nextInt();
		System.out.println("Giai thừa của " + n + " là: " + tinhGiaiThua(n));
	}
}
