public class ParkingSpot {
    private int spotNumber;
    private SpotType spotType;
    private boolean isFree;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, SpotType spotType){
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.isFree = true;
        this.parkedVehicle = null;
    }

    public boolean isFree(){
        return isFree;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean park(Vehicle v){
        if(!isFree){
            System.out.println("Acest loc este deja ocupat!");
            return false;
        }

        this.parkedVehicle = v;
        this.isFree = false;
        System.out.println("Vehiculul: " + parkedVehicle.getLicensePlate() + "a parcat pe locul: " + this.spotNumber);
        return true;
    }

    public void removeVehicle(){
        if(isFree){
            System.out.println("Acest loc este deja liber!");
            return;
        }

        System.out.println("Locul cu numarul: " + this.spotNumber + "a fost eliberat de vehiculul: " + this.parkedVehicle.getLicensePlate());
        this.parkedVehicle = null;
        this.isFree = true;
    }

    public boolean canFitVehicle(Vehicle v){

        if(v.getType() == VehicleType.CAR && (this.spotType == SpotType.CAR || this.spotType == SpotType.TRUCK)){
            return true;
        }
        else if (v.getType() == VehicleType.CAR && this.spotType == SpotType.MOTORCYCLE){
            return false;
        }
        else if (v.getType() == VehicleType.TRUCK && this.spotType == SpotType.TRUCK){
            return true;
        }
        else if (v.getType() == VehicleType.TRUCK && (this.spotType == SpotType.CAR||this.spotType == SpotType.MOTORCYCLE)){
            return false;
        }
        else{
            return true;
        }
    }
}
