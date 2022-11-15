import java.util.Scanner;

public class GiaiPhuongTrinhBacHai {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		float a = sc.nextFloat();
		System.out.println("Nhập giá trị b: ");
		float b = sc.nextInt();
		System.out.println("Nhập giá trị c: ");
		float c = sc.nextInt();
		PTBacHai(a,b,c);
	}
	public static void PTBacHai(float a, float b, float c) {
		if(a==0) {
			if(b==0) {
				System.out.println("PT Vô Nghiệm");
			}else {
				System.out.println("PT có 1 nghiệm: " + (-c/b));
			}
			return;
		}
		
		float delta = (b*b)-(4*a*c);
		float x1,x2;
		if(delta < 0) {
			System.out.println("PT vô nghiệm !!");
		}else if(delta == 0) {
			x1 = -b/(2*a);
			System.out.println("PT có nghiệm kép: " + " x1 = x2 " + x1);
		}else {
			x1 = (float) ((-b - Math.sqrt(delta)) / (2*a));
			x2 = (float) ((-b + Math.sqrt(delta)) / (2*a));
			System.out.println("PT có hai nghiệm ");
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}
	}
	
}
