public class Truck extends Vehicle {

    public Truck(String licensePlate){
        super(licensePlate, VehicleType.TRUCK);
    }

    @Override
    public void printDetails(){
        System.out.println("Camionul are numarul de inmatriculare: " + getLicensePlate());
    }
}
