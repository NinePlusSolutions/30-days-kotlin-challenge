
public class Computer {
	private Company company;
	private Date dateComputer;
	private double price,warrantyTime;
	
	public Computer(Company company, Date dateComputer, double price, double warrantyTime) {
		this.company = company;
		this.dateComputer = dateComputer;
		this.price = price;
		this.warrantyTime = warrantyTime;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Date getDateComputer() {
		return dateComputer;
	}
	public void setCompany(Date dateComputer) {
		this.dateComputer = dateComputer;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getWarrantyTime() {
		return warrantyTime;
	}
	public void setWarrantyTime(double warrantyTime) {
		this.warrantyTime = warrantyTime;
	}
	
	public String checkComputer() {
		return this.company.nameCountry();
	}
	
	public boolean checkPrice(Computer computers) {
		return this.price < computers.price;
	}
	
	@Override
	public String toString() {
		return "Computer = [ " + company + dateComputer + ", Giá Tiền: " + price + ", Thời gian bảo hành:  " + warrantyTime + " ]";
	}
	
}
