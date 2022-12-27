
public class Main {
	public static void main(String[] args) {
		Date date = new Date(2,22,1916);
		Date date1 = new Date(3,3,1917);
		Date date2 = new Date(4,4,1918);
		
		Author author = new Author("Xuân Diệu 01 ", date);
		Author author1 = new Author("Xuân Diệu 02 ", date1);
		Author author2 = new Author("Xuân Diệu 03 ", date2);
		
		Book book = new Book("Thơ Xuân Diệu ",38000,2019, author);
		Book book1 = new Book("Thơ Xuân Quỳnh ",45000,2020, author1);
		Book book2 = new Book("Thơ Nguyễn Bính ",50000,2021, author2);
		
		System.out.println(""+ book);
		System.out.println(""+ book2);
		System.out.println(""+ book2);
		
		book.printBook();
		System.out.println("Kiểm Tra NXB book vs book1: " + book.kiemTraCungNXB(book1));
		System.out.println(" Giá tiền sau khi giảm 10% giá book1 " + book1.disCount(10));
		System.out.println(" Giá tiền sau khi giảm 20% giá book " + book.disCount(20));
		System.out.println(" Giá tiền sau khi giảm 10% giá book2 " + book2.disCount(10));
	}
}
