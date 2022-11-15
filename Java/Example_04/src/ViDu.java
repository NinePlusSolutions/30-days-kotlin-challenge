import java.util.Scanner;

public class ViDu {
	public static void main(String arg[]) {
		double a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextDouble();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextDouble();
		
		//Ham abs
		System.out.println("|a| = " + Math.abs(a));
		//Ham min
		System.out.println("Giá trị nhỏ nhất: "+ Math.min(a, b));
		//Ham max
		System.out.println("Giá trị lớn nhất: " + Math.max(a, b));
		//Ham ceil
		System.out.println("Ceil(a): " + Math.ceil(a));
		//Ham floor
		System.out.println("floor(a): " + Math.floor(a));
		//Ham sqrt
		System.out.println("Sqrt: " + Math.sqrt(a));
	}
}
