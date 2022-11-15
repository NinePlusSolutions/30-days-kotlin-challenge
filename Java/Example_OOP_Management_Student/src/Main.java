
public class Main {
	public static void main(String[] args) {
		BirthDay birthday = new BirthDay(5,2,2000);
		BirthDay birthday1 = new BirthDay(25,11,2000);
		BirthDay birthday2 = new BirthDay(5,2,2000);
		
		ClassMate classmate = new ClassMate("18T1","Công Nghệ Số");
		ClassMate classmate1 = new ClassMate("18KT1", "Kinh Tế Quốc Tế");
		ClassMate classmate2 = new ClassMate("19LKT1", "Luật Kinh Tế");
		
		Students student = new Students(11,"Võ Anh Nguyên ", birthday, classmate, 4);
		Students student1 = new Students(11,"Lê Thị Quỳnh Như ", birthday1, classmate1, 10);
		Students student2 = new Students(11,"Nguyễn Văn A ", birthday2, classmate2, 6);
		
		System.out.println("Tên khoa mà Sinh Viên Theo Học: " + student.checkFaculty());
		System.out.println("Tên khoa mà Sinh Viên Theo Học: " + student1.checkFaculty());
		System.out.println("Tên khoa mà Sinh Viên Theo Học: " + student2.checkFaculty());
		
		System.out.println("" + student.checkPoin());
		System.out.println("" + student1.checkPoin());
		System.out.println("" + student2.checkPoin());
		
		System.out.println("Kiểm tra ngày sinh này sinh sv vs sv1: " + student.checkBirthDay(student1));
		System.out.println("Kiểm tra ngày sinh này sinh sv vs sv2: " + student.checkBirthDay(student2));
	}
}
