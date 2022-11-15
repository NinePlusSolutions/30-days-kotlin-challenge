package bai1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ManagementOfficer mo = new ManagementOfficer();
		while(true) {
			System.out.println("Menu-------------");
			System.out.println("Vui lòng chọn chức năng: ");
			System.out.println("1. Thêm mới cán bộ.\n"
					+ "2. Tìm kiếm theo họ tên.\n"
					+ "3. Hiển thị thông tin danh sách các cán bộ.\n"
					+ "0. Thoát khỏi chương trình.");
			String line = sc.nextLine();
			switch(line) {
				case "1" : {
					 System.out.println("Enter a: to insert Enginner");
	                 System.out.println("Enter b: to insert Worker");
	                 System.out.println("Enter c: to insert Staff");
	                 String type = sc.nextLine();
	                 switch(type) {
	                 	case "a": {
	                 		System.out.println("Nhập họ: ");
	    					String name = sc.nextLine();
	    					System.out.println("Nhập tuổi: ");
	    					int age = sc.nextInt();
	    					System.out.println("Nhập giới tính: ");
	    					sc.nextLine();
	    					String genner = sc.nextLine();
	    					System.out.println("Nhập địa chỉ: ");
	    					String address = sc.nextLine();
	    					System.out.println("Nhập ngành");
	    					String branch = sc.nextLine();
	    					Officer engineer = new Engineer(name,age,genner,address,branch);
	    					mo.addOfficer(engineer);
	    					System.out.println(engineer.toString());
                            break;
	                 	}
	                 	case "b" : {
	                 		System.out.println("Nhập họ tên: ");
	    					String name = sc.nextLine();
	    					System.out.println("Nhập tuổi: ");
	    					int age = sc.nextInt();
	    					System.out.println("Nhập giới tính: ");
	    					sc.nextLine();
	    					String genner = sc.nextLine();
	    					System.out.println("Nhập địa chỉ: ");
	    					String address = sc.nextLine();
	    					System.out.println("Nhập trình độ: ");
	    					int level = sc.nextInt();
	    					Officer worker = new Worker(name,age,genner,address,level);
	    					mo.addOfficer(worker);
	    					System.out.println(worker.toString());
                            break;
	                 	}
	                 	case "c" : {
	                 		System.out.println("Nhập họ: ");
	    					String name = sc.nextLine();
	    					System.out.println("Nhập tuổi: ");
	    					int age = sc.nextInt();
	    					System.out.println("Nhập giới tính: ");
	    					sc.nextLine();
	    					String genner = sc.nextLine();
	    					System.out.println("Nhập địa chỉ: ");
	    					String address = sc.nextLine();
	    					System.out.println("Nhập ngành");
	    					String branch = sc.nextLine();
	    					System.out.println("Nhập trình độ: ");
	    					String task = sc.nextLine();
	    					Officer staff = new Staff(name,age,genner,address,task);
	    					mo.addOfficer(staff);
	    					System.out.println(staff.toString());
                            break;
	                 	}
	                 	default: 
	                 		System.out.println("Invalid");
                            break;
	                 }
	                 break;
				}
			case "2" :
				System.out.println("Enter name to search: ");
				String name = sc.nextLine();
				System.out.println("List officer: ");
				mo.filter(name);
				break;
			case "3" :
				mo.printOfficer();
				break;
			 case "4": {
                 return;
             }
             default:
                 System.out.println("Invalid");
                 continue;
			}
		}
	}
}

