package main;

import java.util.Objects;

public class SinhVien {
	private String maSV, hoTen;
	private int namSinh;
	private float diemTB;
	
	public SinhVien(String maSV, String hoTen, int namSinh, float diemTB) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diemTB = diemTB;
	}
	
	public SinhVien(String maSV) {
		this.maSV = maSV;
	}

	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	
	public float getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", namSinh=" + namSinh + ", diemTB=" + diemTB + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(maSV, other.maSV);
	}
	
	
	
}
