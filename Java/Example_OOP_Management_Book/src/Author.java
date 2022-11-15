
public class Author {
	private String name;
	private Date ngaySinh;
	
	public Author(String name, Date ngaySinh) {
		this.name = name;
		this.ngaySinh = ngaySinh;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaSinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	@Override
	public String toString() {
		return   name + "," + ngaySinh ;
	}
	
}
