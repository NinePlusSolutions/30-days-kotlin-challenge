package bai1;

public class Staff  extends Officer {
	private String task;
	
	public Staff(String name, int age, String genner, String address, String task) {
		super(name,age,genner,task);
		this.task = task;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	@Override
	public String toString() {
		return  "Staff{" +
                "task='" + task + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
	}
}
