package test;

import java.util.Scanner;
import main.DanhSachSinhVien;
import main.SinhVien;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		int luaChon = 0;
		do {
			System.out.println("Menu-------------");
			System.out.println("Vui lòng chọn chức năng: ");
			System.out.println("1. Thêm sinh viên vào danh sách.\n"
					+ "2. In danh sách sinh viên ra màn hình.\n"
					+ "3. Kiểm tra danh sách sinh viên có rỗng hay không.\n"
					+ "4. Lấy ra số lượng có trong danh sách.\n"
					+ "5. Làm rỗng danh sách sinh viên.\n"
					+ "6. Kiểm tra danh sách sinh viên có tồn tại hay không, dựa trên mã sinh viên.\n"
					+ "7. Xoá sinh viên ra khỏi danh sách dựa trên mã sinh viên.\n"
					+ "8. Tìm kiếm tất cả sinh viên dựa trên Tên được nhập từ bàn phím.\n"
					+ "9. Xuất ra danh sách sinh viên có điểm từ cao đến thấp.\n"
					+ "0. Thoát khỏi chương trình.");
			luaChon = sc.nextInt();
			sc.nextLine();
			if(luaChon == 1) {
				System.out.println("Nhập mã sinh viên: ");
				String maSV = sc.nextLine();
				System.out.println("Nhập họ sinh viên: ");
				String hoTen = sc.nextLine();
				System.out.println("Nhập năm sinh viên: ");
				int namSinh = sc.nextInt();
				System.out.println("Nhập điểm trung bình: ");
				float diemTB = sc.nextFloat();
				SinhVien sv = new SinhVien(maSV,hoTen,namSinh,diemTB);
				dssv.addSinhVien(sv);
			}else if(luaChon == 2) {
				dssv.printSinhVien();
			}else if(luaChon == 3) {
				System.out.println("Kiểm tra danh sách sinh viên: " + dssv.checkSinhVien());
			}else if(luaChon == 4) {
				System.out.println("Số lượng sinh viên: " + dssv.soLuongSinhVien());
			}else if(luaChon == 5) {
				dssv.lamRong();
			}else if(luaChon == 6) {
				System.out.println("Nhập mã SV: ");
				String maSV = sc.nextLine();
				SinhVien sv = new SinhVien(maSV);
				System.out.println("Sinh viênn có tồn tại không:  " + dssv.checkSVTonTai(sv));
			}else if(luaChon == 7) {
				System.out.println("Nhập mã SV: ");
				String maSV = sc.nextLine();
				SinhVien sv = new SinhVien(maSV);
				System.out.println("Sinh viên đã xoá:  " + dssv.deleteSinhVienId(sv));
			}else if(luaChon == 8) {
				System.out.println("Nhập ten SV: ");
				String hoTen = sc.nextLine();
				System.out.println("Danh sách Sinh Viên: " );
				dssv.filter(hoTen);;
			}else if(luaChon == 9) {
				dssv.sapXepSVGiamDanTheoDiem();
				dssv.printSinhVien();
			}else if(luaChon == 0) {
				
			}
		}while(luaChon !=0);
	}
}
