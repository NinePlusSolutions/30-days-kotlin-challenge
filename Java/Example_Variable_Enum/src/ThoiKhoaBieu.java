
public class ThoiKhoaBieu {
	private Day thu;
	private String monhoc;
	
	public ThoiKhoaBieu(Day thu, String monhoc) {
		this.monhoc = monhoc;
		this.thu = thu;
	}
	
	public Day getDau() {
		return thu;
	}
	public void setDay(Day thu) {
		this.thu = thu;
	}
	
	public String monhoc() {
		return monhoc;
	}
	public void setMonHoc(String monhoc) {
		this.monhoc = monhoc;
	}
	
	@Override
	public String toString() {
		return "Thời khoá biểu = [ " +  "Thứ: " + thu + ", Môn học: " + monhoc + " ] ";
	}
	
}
