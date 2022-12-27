package bai1;

import java.util.ArrayList;

public class ManagementOfficer {
	private ArrayList<Officer> listOfficer;
	
	public ManagementOfficer() {
		this.listOfficer = new ArrayList<Officer>();
	}
	
	public ManagementOfficer(ArrayList<Officer> listOfficer) {
		super();
		this.listOfficer = listOfficer;
	}
	
	public void addOfficer(Officer or) {
		this.listOfficer.add(or);
	}
	
	public void printOfficer() {
		for (Officer officer : listOfficer) {
			System.out.println(officer);
		}
	}
//	public void showListInforOfficer() {
//        this.listOfficer.forEach(o -> System.out.println(o.toString()));
//    }
	public void filter(String name) {
		for (Officer officer : listOfficer) {
			if(officer.getName().indexOf(name) >= 0) {
				System.out.println(officer);
			}
		}
	}
}
