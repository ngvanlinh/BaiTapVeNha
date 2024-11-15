package model;

public class Vehicle {
    private int id;
    private String nhanHieu;
    private String kieuXe;
    private String bienSoXe;

    public Vehicle() {
    }

    public Vehicle(int id, String kieuXe, String nhanHieu, String bienSoXe) {
        this.id = id;
        this.kieuXe = kieuXe;
        this.nhanHieu = nhanHieu;
        this.bienSoXe = bienSoXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNhanHieu() {
        return nhanHieu;
    }

    public void setNhanHieu(String nhanHieu) {
        this.nhanHieu = nhanHieu;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public double calculateParkingFee() {
        return 0;
    }
}
