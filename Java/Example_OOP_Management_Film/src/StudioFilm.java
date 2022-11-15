
public class StudioFilm {
	private String nameStudio, countryStudio;
	
	public StudioFilm(String nameStudio, String countryStudio) {
		this.nameStudio = nameStudio;
		this.countryStudio = countryStudio;
	}
	
	public String getNameStudio() {
		return nameStudio;
	}
	public void setNameStudio(String nameStudio) {
		this.nameStudio = nameStudio;
	}
	
	public String getCountryStudio() {
		return countryStudio;
	}
	public void setCountryStudio(String countryStudio) {
		this.countryStudio = countryStudio;
	}

	@Override
	public String toString() {
		return "Tên Hãng Phim: " + nameStudio + ", Quốc Gia" + countryStudio ;
	}
}
