import java.util.Objects;

public class Level {
    private ParkingSpot[] parkingSpots;

    public Level(ParkingSpot[] parkingSpots){
        this.parkingSpots = parkingSpots;
    }

    public int findAvailableSpot(Vehicle v){
        for(int i = 0;i<parkingSpots.length;i++) {
            if (parkingSpots[i].isFree() && parkingSpots[i].canFitVehicle(v)) {
                return parkingSpots[i].getSpotNumber();
            }
        }
        return -1;
    }

    public int freeSpot(String licensePlate){
        for(int i = 0;i<parkingSpots.length;i++) {
            // Verificăm MAI ÎNTÂI dacă locul NU este liber, abia apoi îi cerem numărul
            if (!parkingSpots[i].isFree() && Objects.equals(parkingSpots[i].getParkedVehicleLicensePlate(), licensePlate)) {
                parkingSpots[i].removeVehicle();
                return parkingSpots[i].getSpotNumber();
            }
        }
        return -1;
    }


    public ParkingSpot getSpot(int spotNumber){
        for(int i = 0;i<parkingSpots.length;i++) {
            if (parkingSpots[i].getSpotNumber() == spotNumber){
                return parkingSpots[i];
            }
        }
        return null;
    }
}
