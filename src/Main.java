public class Main {
    public static void main(String[] args) {
        System.out.println("--- DESCHIDEM PARCAREA ---\n");

        // 1. Luăm instanța unică a parcării
        ParkingLot lot = ParkingLot.getInstance();

        // 2. Creăm niște vehicule
        Vehicle car1 = new Car("B-01-ABC");
        Vehicle moto1 = new Motorcycle("CJ-99-MOTO");
        Vehicle truck1 = new Truck("B-100-TRUCK");
        Vehicle car2 = new Car("TM-55-XXX");

        // 3. Le parcăm
        lot.parkVehicle(car1);
        lot.parkVehicle(moto1);
        lot.parkVehicle(truck1);
        lot.parkVehicle(car2);

        System.out.println("--- O MAȘINĂ PLEACĂ ---\n");

        // 4. Scoatem prima mașină
        lot.unparkVehicle("B-01-ABC");

        System.out.println("\n--- VINE O MAȘINĂ NOUĂ ---\n");

        // 5. Parcăm altă mașină (ar trebui să ia locul proaspăt eliberat)
        Vehicle car3 = new Car("IS-77-BOS");
        lot.parkVehicle(car3);
    }
}