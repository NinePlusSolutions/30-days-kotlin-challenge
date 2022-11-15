
public class Main {
	public static void main(String[] args) {
		Date date = new Date(21,11,2022);
		StudioFilm studio = new StudioFilm("Nhựa Studio", "Việt Nam");
		InfoFlim film = new InfoFlim("Gara Hạnh Phúc",studio,65000,date);
		InfoFlim film1 = new InfoFlim("",studio,73000,date);
		
		System.out.println("Check giá vé"+ film.checkPrice(film1));
		System.out.println("Check hãng phim: "+ film.checkFlim());
		System.out.println("Giá tiền sau khi giảm 10%: " + film.disCount(10));
	}
}
