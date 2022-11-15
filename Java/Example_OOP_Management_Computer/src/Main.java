public class Main {
	public static void main(String[] args) {	
		
		Date date = new Date(11,11,2020);
		Date date1 = new Date(11,11,2020);
		Date date2 = new Date(11,11,2020);
		
		Country country = new Country(84, " Việt Nam ");
		Country country1 = new Country(1, " American ");
		Country country2 = new Country(82, " Korea ");
		
		Company company = new Company(" Vsmart ", country);
		Company company1 = new Company(" Dell ", country1);
		Company company2 = new Company(" SamSumg ", country2);
		
		Computer computer = new Computer(company,date,190000, 12);
		Computer computer1 = new Computer(company1,date1,250000, 12);
		Computer computer2 = new Computer(company2,date2,100000, 12);
		
		System.out.println(" " + computer);
		
		System.out.println("Hãng Dell Quốc Gia Nào Sản Xuất: " + computer1.checkComputer());
		System.out.println("Hãng Vsmart Quốc Gia Nào Sản Xuất: " + computer.checkComputer());
		System.out.println("Hãng Samsung Quốc Gia Nào Sản Xuất: " + computer2.checkComputer());
		
		System.out.println("So sánh giá Dell vs Vsmart: " + computer1.checkPrice(computer));
		System.out.println("So sánh giá Vsmart vs Samsung: " + computer2.checkPrice(computer));
	}
}
