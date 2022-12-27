
public class MayBay extends PhuongTienDiChuyen {

	private String loaiNhienLieu;
	
	public MayBay(String loaiNhieuLieu, HangSanXuat hangSanXuat) {
		super(" Máy Bay", hangSanXuat);
		this.loaiNhienLieu = loaiNhieuLieu;
	}

	public String getLoaiNhienLieu() {
		return loaiNhienLieu;
	}

	public void setLoaiNhienLieu(String loaiNhienLieu) {
		this.loaiNhienLieu = loaiNhienLieu;
	}
	
	public void CatCanh() {
		System.out.println("Cất Cánh......");
	}
	
	public void HaCanh() {
		System.out.println("Hạ Cánh......");
	}

	@Override
	public double LayVanToc() {
		return 300;
	}
}
