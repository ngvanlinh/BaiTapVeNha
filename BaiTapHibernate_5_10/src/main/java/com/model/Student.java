package com.model;

public class Student {
    private int id;
    private String HoTen;
    private String Lop;
    private String DiaChi;
    private int Diem;

    public Student() {
    }

    public Student(int id, String hoTen, String lop, String diaChi, int diem) {
        this.id = id;
        HoTen = hoTen;
        Lop = lop;
        DiaChi = diaChi;
        Diem = diem;
    }

    public Student(String hoTen, String lop, String diaChi, int diem) {
        this.HoTen = hoTen;
        this.Lop = lop;
        this.DiaChi = diaChi;
        this.Diem = diem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getDiem() {
        return Diem;
    }

    public void setDiem(int diem) {
        Diem = diem;
    }
}
