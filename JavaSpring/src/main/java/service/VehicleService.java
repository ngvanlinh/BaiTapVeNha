package service;

import model.Vehicle;

import java.util.ArrayList;

public class VehicleService {
    private ArrayList<Vehicle> listVerhicle;

    public VehicleService(){
        listVerhicle = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle){
        listVerhicle.add(vehicle);
    }
    public double calculateTotalParkingFee() {
        double tongTienGuiXe = 0;
        for (Vehicle vehicle : listVerhicle) {
            tongTienGuiXe += vehicle.calculateParkingFee();
        }
        return tongTienGuiXe;
    }
    public void printParkingLotDetails() {
        for (Vehicle vehicle : listVerhicle) {
            System.out.println("ID: " + vehicle.getId() + ", Nhãn Hiệu: " + vehicle.getNhanHieu() +
                    ", Kiểu xe: " + vehicle.getKieuXe() + ",  Biển số : " + vehicle.getBienSoXe() +
                    ", phí đỗ xe : " + vehicle.calculateParkingFee()+ " $");
        }
    }
}
