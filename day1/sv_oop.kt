package com.example.day1

fun main(){
    var sv1 :SinhVien= SinhVien()
    sv1.HoTen="Bui Dang Duong"
    sv1.DiaChi="Da Nang"
    sv1.Tuoi=22
    //print(sv1.HoTen+sv1.DiaChi+sv1.Tuoi)


    val ptien:PhuongTien= PhuongTien("xe dap","do",2)
    print("phuongtien:"+ptien.ten+ptien.mau+ptien.banh)
}