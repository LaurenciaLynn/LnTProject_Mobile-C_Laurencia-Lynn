
// Concrete class for Car
class Car extends Vehicle {
    private String carType; // SUV, Supercar, Minivan
    private int entertainmentSystemCount;

    // Constructor
    public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String carType, int entertainmentSystemCount) {
        super("Car", brand, name, licenseNumber, topSpeed, gasCap, wheel);
        this.carType = carType;
        this.entertainmentSystemCount = entertainmentSystemCount;
    }

    // Override abstract method
    @Override
    void additionalInfo() {
        System.out.println("Car Type: " + carType);
        System.out.println("Entertainment System Count: " + entertainmentSystemCount);
    }

    // Additional method for turning on entertainment system
    public void turnOnEntertainmentSystem() {
        System.out.println("Turning on entertainment system...");
    }
}
