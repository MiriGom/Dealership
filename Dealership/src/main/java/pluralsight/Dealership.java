package pluralsight;
import java.util.ArrayList;
import java.util.List;

//Class and declared private variables
public class Dealership {
    private final String name;
    private final String address;
    private final String phone;
    private final ArrayList<Vehicle> inventory = new ArrayList<>();


    //Main constructor
    Dealership(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    //methods
    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() > min && v.getPrice() < max) {
                filteredList.add(v);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return filteredList;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                filteredList.add(v);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return filteredList;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle v : inventory){
            if (v.getYear() >= min && v.getYear() <= max) {
                filteredList.add(v);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return filteredList;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)){
                filteredList.add(v);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return filteredList;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() > min && v.getOdometer() < max) {
                filteredList.add(v);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return filteredList;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                filteredList.add(v);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return filteredList;
    }
    public List<Vehicle> getAllVehicles(){
        if (inventory.isEmpty()) {
            System.out.println("\nSorry no vehicles found");
        }
        return inventory;
    }
    public Vehicle getVehicleByVin(int userCarVin) {
        for (Vehicle v : inventory) {
            if (v.getVin() == userCarVin) {
                return v;
            }
        } return null;
    }
    public void addVehicle(Vehicle v) {
        inventory.add(v);

    }
    public void removeVehicle(Vehicle v){
        inventory.remove(v);
    }

}
