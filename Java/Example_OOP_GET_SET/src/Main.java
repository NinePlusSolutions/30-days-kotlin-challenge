
public class Main {
	public static void main(String[] args) {
		MyDate md = new MyDate(11,11,2022);
		System.out.println("Day = " + md.getDay());
		System.out.println("Month = " + md.getMonth());
		System.out.println("Year = " + md.getYear());
		md.setDay(5);
		System.out.println("Day = " + md.getDay());
		md.setMonth(12);
		System.out.println("Month = " + md.getMonth());
		md.setYear(2023);
		System.out.println("Year = " + md.getYear());
	}
}
