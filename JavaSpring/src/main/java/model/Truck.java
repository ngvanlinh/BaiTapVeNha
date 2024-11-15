package model;

public class Truck extends Vehicle{
    private int loadCapacity;
    public double calculateParkingFee(){
    return 20.0 * loadCapacity;
    }

    public Truck(int id, String kieuXe, String nhanHieu, String bienSoXe, int loadCapacity) {
        super(id, kieuXe, nhanHieu, bienSoXe);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
