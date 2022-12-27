package main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
	private ArrayList<SinhVien> danhsach;
	
	public DanhSachSinhVien() {
		this.danhsach = new ArrayList<SinhVien>();
	}
	
	public DanhSachSinhVien(ArrayList<SinhVien> danhsach) {
		super();
		this.danhsach = danhsach;
	}
	// Thêm danh sách sinh viên	
	public void addSinhVien(SinhVien sv) {
		this.danhsach.add(sv);
	}
	// In danh sách sinh viên	
	public void printSinhVien() {
		for (SinhVien sinhVien : danhsach) {
			System.out.println(sinhVien);
		}
	}
	
	// Check sinh vien rong	
	public boolean checkSinhVien() {
		return this.danhsach.isEmpty();
	}
    // Lấy số lượng SV	
	public int soLuongSinhVien() {
		return this.danhsach.size();
	}
    // Làm rỗng danh sách sinh viên	
	public void lamRong() {
		this.danhsach.removeAll(danhsach);
	}
    //	ktra sv có tồn tại hay không
	public boolean checkSVTonTai(SinhVien sv) {
		return this.danhsach.contains(sv);
	}
	// xoá danh sách sv 
	public boolean deleteSinhVienId(SinhVien sv) {
		return this.danhsach.remove(sv);
	}
	// Tìm kiếm danh sách sv nhập từ bàn phím	
	public void filter(String ten) {
		for (SinhVien sinhVien : danhsach) {
			if(sinhVien.getHoTen().indexOf(ten) >= 0) {
				System.out.println(sinhVien);
			}
		}
	}
	//	Xuất danh sách sv có điểm từ cao đến thấp
	public void sapXepSVGiamDanTheoDiem() {
		Collections.sort(this.danhsach, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
				if(sv1.getDiemTB() > sv2.getDiemTB()) {
					return -1;
				}else if(sv1.getDiemTB() < sv2.getDiemTB()) {
					return 1;
				}else {
					return 0;
				}
			}
		});
	}
}
