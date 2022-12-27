
public class MyDate {
	private int day,month,year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public void printDay() {
		System.out.println("Day: " + this.day);
	}
	public void printMonth() {
		System.out.println("Month: " + this.month);
	}
	public void printYear() {
		System.out.println("Year: " + this.year);
	}
	public void printDate() {
		System.out.println("Date: " + this.day + " - " + this.month + " - " + this.year);
	}
}
