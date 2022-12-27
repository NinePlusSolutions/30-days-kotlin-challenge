
public class Country {
	private int iD;
	private String nameCountry;
	
	public Country(int iD, String nameCountry) {
		this.iD = iD;
		this.nameCountry = nameCountry;
	}
	
	public int getID() {
		return iD;
	}
	public void setID( int iD) {
		this.iD = iD;
	}
	
	public String getNameCountry() {
		return nameCountry;
	}
	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}
	
	@Override
	public String toString() {
		return " Mã Quốc Gia: " + iD + ", Tên Quốc Gia: " + nameCountry;
	}
	
}

