public class Car extends Vehicle{

    public Car(String licensePlate){
        super(licensePlate, VehicleType.CAR);
    }

    @Override
    public void printDetails(){
        System.out.println("Numarul de inmatriculare al masinii este: " + getLicensePlate());
    }
}
