public class ParkingLot {

    private static ParkingLot instance;

    private Level[] levels;

    private ParkingLot(){
        this.levels = new Level[2];

        for (int i = 0; i < levels.length; i++) {
            ParkingSpot[] spotsForThisLevel = new ParkingSpot[10];

            // Populăm array-ul cu locuri (exemplu simplificat de inițializare)
            spotsForThisLevel[0] = new ParkingSpot(1, SpotType.MOTORCYCLE);
            spotsForThisLevel[1] = new ParkingSpot(2, SpotType.MOTORCYCLE);
            spotsForThisLevel[2] = new ParkingSpot(3, SpotType.CAR);
            spotsForThisLevel[3] = new ParkingSpot(4, SpotType.CAR);
            spotsForThisLevel[4] = new ParkingSpot(5, SpotType.CAR);
            spotsForThisLevel[5] = new ParkingSpot(6, SpotType.CAR);
            spotsForThisLevel[6] = new ParkingSpot(7, SpotType.CAR);
            spotsForThisLevel[7] = new ParkingSpot(8, SpotType.CAR);
            spotsForThisLevel[8] = new ParkingSpot(9, SpotType.TRUCK);
            spotsForThisLevel[9] = new ParkingSpot(10, SpotType.TRUCK);

            levels[i] = new Level(spotsForThisLevel);
        }
    }

    public static ParkingLot getInstance() {
        // Dacă parcarea nu a fost construită încă, o construim acum
        if (instance == null) {
            instance = new ParkingLot();
        }
        // Dacă a fost construită, o returnăm pe cea existentă
        return instance;
    }

    public boolean parkVehicle(Vehicle v){
        for (int i=0;i < levels.length;i++){
            int spotNumber = levels[i].findAvailableSpot(v);
            if(spotNumber!=-1){
                ParkingSpot spot = levels[i].getSpot(spotNumber);
                spot.park(v);
                System.out.println("SUCCES! Vehiculul cu numarul: " + v.getLicensePlate() + " a parcat la etajul: " + i + " pe locul cu numarul: " + spotNumber + "\n");
                return true;
            }
        }
        System.out.println("ESEC! Parcarea este plina sau nu exista locuri compatibile" + "\n");
        return false;
    }

    public void unparkVehicle(String licensePlate){
        for(int i = 0;i<levels.length;i++){
            int spotNumber = levels[i].freeSpot(licensePlate);
            if(spotNumber!=-1){
                System.out.println("Vehiculul cu numarul: " + licensePlate + " a plecat de pe locul: " + spotNumber + " de la etajul: " + i);
            }
        }
    }
}
