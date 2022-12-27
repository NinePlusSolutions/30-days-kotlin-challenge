import java.util.Scanner;

public class BaiTap {
	public static void main(String arg[]) {
		double a,b,c,x1,x2,delta;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập a: ");
		a = sc.nextDouble();
		System.out.println("Nhập b: ");
		b = sc.nextDouble();
		System.out.println("Nhập c: ");
		c = sc.nextDouble();
		
		delta = (Math.pow(b,2)-4*a*c);
		if(a == 0) {
			System.out.println("Nhập dữ liệu sai!!");
		}else {
			if(delta < 0) {
				System.out.println("PT vô nghiệm");
			}else if(delta == 0) {
				x1 = x2 = -b/(2*a);
				System.out.println("PT có nghiệm kép: x1 = x2" + x1);
			}else{
				x1 = -b - (Math.sqrt(delta)/(2*a));
				x2 = -b + (Math.sqrt(delta)/(2*a));
				System.out.println("PT có hai nghiệm: " + "x1= "+ x1 + " x2= " + x2);
			}
		}
	}
}
