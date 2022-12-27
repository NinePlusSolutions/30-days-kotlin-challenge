
public class ClassMate {
	private String nameClass, nameFaculty;
	
	public ClassMate(String nameClass, String nameFaculty) {
		this.nameClass = nameClass;
		this.nameFaculty = nameFaculty;
	}
	
	public String getNameClass() {
		return nameClass;
	}
	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}
	
	public String getNameFaculty() {
		return nameFaculty;
	}
	public void setNameFaculty(String nameFaculty) {
		this.nameFaculty = nameFaculty;
	}
	
	@Override
	public String toString() {
		return " [Tên lớp: " + nameClass + " Tên khoa: " + nameFaculty + "]";
	}
}
