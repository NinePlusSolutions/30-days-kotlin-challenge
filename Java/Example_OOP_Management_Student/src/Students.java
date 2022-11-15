import java.util.Objects;

public class Students {
	private int id;
	private String nameStudents;
	private float mediumScore;
	private ClassMate classMate;
	private BirthDay birthDay;
	public Students(int id, String nameStudents, BirthDay birthDay, ClassMate classMate, float mediumScore) {

		this.id = id;
		this.nameStudents = nameStudents;
		this.birthDay = birthDay;
		this.classMate = classMate;
		this.mediumScore = mediumScore;
	}
	public int getId() {
		return id;
	}
	public void setId(int Id) {
		this.id = Id;
	}
	
	public String getNameStudents() {
		return nameStudents;
	}
	public void setNameStudents(String nameStudents) {
		this.nameStudents = nameStudents;
	}
	
	public float getMediumScore() {
		return mediumScore;
	}
	public void setMediumScore(float mediumScore) {
		this.mediumScore = mediumScore;
	}
	
	public ClassMate getClassMate() {
		return classMate;
	}
	public void setClassMate(ClassMate classMate) {
		this.classMate = classMate;
	}
	
	public BirthDay getBirthDate() {
		return birthDay;
	}
	public void setBirthDay(BirthDay birthDay) {
		this.birthDay = birthDay;
	}
	
	public String checkFaculty() {
		return this.classMate.getNameFaculty();
	}
	
	public String checkPoin() {
		if( this.getMediumScore() >= 5) {
			return this.nameStudents + " Đậu ";
		}
		return this.nameStudents + "Rớt";
	}
	public boolean checkBirthDay( Students sv) {
		return this.birthDay.equals(sv.birthDay);
	}
	
	@Override
	public String toString() {
		return " Mã Học Sinh: " + id + " Tên Học Sinh: " + nameStudents + " Điểm Trung Bình: " + mediumScore + " Lớp: " 
				+ classMate + " Ngày sinh: " + birthDay;
	}
}
