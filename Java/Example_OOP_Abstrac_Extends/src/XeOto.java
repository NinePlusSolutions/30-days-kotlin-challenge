
public class XeOto extends PhuongTienDiChuyen {
	private String loaiNhienLieu;
	
	public XeOto(String loaiNhieuLieu, HangSanXuat hangSanXuat) {
		super(" Xe Ô tô", hangSanXuat);
		this.loaiNhienLieu = loaiNhieuLieu;
	}

	public String getLoaiNhienLieu() {
		return loaiNhienLieu;
	}

	public void setLoaiNhienLieu(String loaiNhienLieu) {
		this.loaiNhienLieu = loaiNhienLieu;
	}
	
	@Override
	public double LayVanToc() {
		return 80;
	}
}
