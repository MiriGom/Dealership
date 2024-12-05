package pluralsight;

//class name and its declared private variables
public class Vehicle {
    private final int vin;
    private final int year;
    private final String make;
    private final String model;
    private final String vehicleType;
    private final String color;
    private final int odometer;
    private final double price;

    //main constructor
    Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price){
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
    //Getters
    public int getVin() {
        return vin;
    }
    public int getYear() {
        return year;
    }
    public String getModel() {
        return model;
    }
    public String getMake() {
        return make;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public String getColor() {
        return color;
    }
    public int getOdometer() {
        return odometer;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Vin:%-10d Year:%-10d Make\\Model:%s %-10s Color:%-10s Type:%-10s Odometer:%-10d Price:$%.2f",
                getVin(), getYear(), getMake(), getModel(), getColor(), getVehicleType(), getOdometer(), getPrice());
    }
}
