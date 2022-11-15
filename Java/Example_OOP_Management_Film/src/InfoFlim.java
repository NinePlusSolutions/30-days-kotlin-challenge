
public class InfoFlim {
	private String nameFilm;
	private StudioFilm studioFilm;
	private double price;
	private Date date;
	
	public InfoFlim(String nameFilm, StudioFilm studioFilm, double price, Date date) {
		this.nameFilm = nameFilm;
		this.studioFilm = studioFilm;
		this.price = price;
		this.date = date;
	}
	
	public String getNameFilm() {
		return nameFilm;
	}
	public void setNameFilm(String nameFilm) {
		this.nameFilm = nameFilm;
	}
	
	public StudioFilm getStudioFilm() {
		return studioFilm;
	}
	public void setStudioFilm(StudioFilm studioFilm) {
		this.studioFilm = studioFilm;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean checkPrice(InfoFlim film) {
		return this.price < film.price;	
	}
	public String checkFlim() {
		return this.studioFilm.getNameStudio();
	}
	
	public double disCount(double x) {
		return this.price * (1-(x/100));
	}
	@Override
	public String toString() {
		return "Tên Phim: " + nameFilm + ", " + studioFilm + ", Giá Tiền: " + price + ", Ngày:" + date;
	}
	
}
