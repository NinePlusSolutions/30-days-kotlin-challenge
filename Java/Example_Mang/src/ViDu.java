import java.util.Scanner;

public class ViDu {
	public static void main(String[] args) {
		double [] mang1, mang2;
		
		mang1 = new double[10];
		Scanner sc = new Scanner(System.in);
		for( int i = 0 ; i < mang1.length ; i++) {
			System.out.println("Phần tử thứ: " + i);
			mang1[i] = sc.nextDouble();
		}
		double tong = 0;
		for (int i = 0 ; i < mang1.length ; i++) {
			tong = tong + mang1[i];
		}
		System.out.println("Tổng của mảng: " + tong);
		
		mang2 = new double[] {1,2,3,4,5};
		for (double d : mang2) {
			System.out.println(d);
		}
	}
}
