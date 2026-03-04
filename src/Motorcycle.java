public class Motorcycle extends Vehicle{
    public Motorcycle(String licensePlate){
        super(licensePlate, VehicleType.MOTORCYCLE);
    }

    @Override

    public void printDetails(){
        System.out.println("Numarul de inmatriculare al motocicletei este: " + getLicensePlate());
    }
}
