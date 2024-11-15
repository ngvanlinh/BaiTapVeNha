package model;

public class Motorcycle extends Vehicle {
    private int hasSidecar;

    public Motorcycle(int id, String kieuXe, String nhanHieu, String bienSoXe, int hasSidecar) {
        super(id, kieuXe, nhanHieu, bienSoXe);
        this.hasSidecar = hasSidecar;
    }

    public int getHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(int hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public double calculateParkingFee() {
        return 5.0;
    }
}
