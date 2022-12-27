
public class Company {
	private String nameCompany;
	private Country country;
	
	public Company(String nameCompany, Country country) {
		this.nameCompany = nameCompany;
		this.country = country;
	}
	
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String nameCountry() {
		return this.country.getNameCountry();
	}
	
	@Override
	public String toString() {
		return " Tên Hãng Sản Xuất: " + nameCompany + ", Quốc Gia: " + country;
	}
}
