import java.util.Scanner;

public class BaiTapCircle {
	public static void main(String arg[]) {
		double r, s,v;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập r: ");
		r = sc.nextDouble();
		
		v = 2*Math.PI*r;
		System.out.println("Chu vi: " + v);
		s = Math.pow(r,2)*Math.PI;
		System.out.println("Diện tích: " + s);
	}
}
