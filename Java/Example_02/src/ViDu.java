import java.util.Scanner;

public class ViDu {
	public static void main(String arg[]) {
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập giá trị a: ");
		a = sc.nextInt();
		System.out.println("Nhập giá trị b: ");
		b = sc.nextInt();
		
		
		System.out.println(a + " == " + b + " : " +(a==b));
		System.out.println(a + " != " + b + " : " +(a!=b));
		System.out.println(a + " <= " + b + " : " +(a<=b));
		System.out.println(a + " >= " + b + " : " +(a>=b));
		
		System.out.println("Số chẵn:" + (a%2==0 && b%2==0));
		System.out.println("Có ít nhất 1 số chẵn:" + (a%2==0 || b%2==0));
	}
}
