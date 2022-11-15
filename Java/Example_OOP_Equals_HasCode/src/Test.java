
public class Test {
	public static void main(String[] args) {
		MyDate md1 = new MyDate(12,2,2020);
		MyDate md2 = new MyDate(25,11,2021);
		MyDate md3 = new MyDate(12,2,2020);
		
		System.out.println("My Date 1: " + md1.toString());
		System.out.println("My Date 1: " + md2.toString());
		System.out.println("My Date 1: " + md3.toString());
		
		System.out.println("so sánh giá trị md1 vs md3: " + md1.equals(md3));
		System.out.println(""+ md1.hashCode());
		System.out.println(""+ md1.hashCode());
		System.out.println(""+ md1.hashCode());
		
	}
}
