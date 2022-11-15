package bai1;

public class Engineer extends Officer {
	private String branch;
	
	public Engineer(String name, int age, String genner, String address, String branch) {
		super(name,age,genner,address);
		this.branch = branch;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return "Engineer{" +
                "branch='" + branch + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
		
	}
}
