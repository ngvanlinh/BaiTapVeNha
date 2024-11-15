package test;

import model.Car;
import model.Motorcycle;
import model.Truck;
import model.Vehicle;
import service.VehicleService;

public class Main {
    public static void main(String[] args) {
        Vehicle car1 = new Car(1, "volvo", "volvo5", "30A-12345", 5);
        Vehicle motorcycle1 = new Motorcycle(1, "Yamaha", "R3", "28A1-34567", 0);
        Vehicle motorcycle2 = new Motorcycle(2, "HonDa", "Vision", "98H1-37764", 1);
        Vehicle truck1 = new Truck(1, "HuynhDai", "HD101", "30F-98765", 50);


        VehicleService vehicleService = new VehicleService();
        vehicleService.addVehicle(car1);
        vehicleService.addVehicle(motorcycle1);
        vehicleService.addVehicle(motorcycle2);
        vehicleService.addVehicle(truck1);

        System.out.println("===========phí đỗ xe của từng loại xe: ========");
        vehicleService.printParkingLotDetails();


        System.out.println(" ============ Tổng phí đỗ xe: =============");
        double totalParkingFee = vehicleService.calculateTotalParkingFee();
        System.out.println("   =  "+ totalParkingFee + " $ ");


    }
}
