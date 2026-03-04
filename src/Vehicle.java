public abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type){
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate(){
        return this.licensePlate;
    }

    public VehicleType getType(){
        return  this.type;
    }

    public abstract void printDetails();
}
