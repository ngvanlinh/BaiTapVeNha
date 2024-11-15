package model;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(int id, String kieuXe, String nhanHieu, String bienSoXe, int numberOfSeats) {
        super(id, kieuXe, nhanHieu, bienSoXe);
        this.numberOfSeats = numberOfSeats;

    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double calculateParkingFee() {
        return 20 * numberOfSeats;
    }
}
