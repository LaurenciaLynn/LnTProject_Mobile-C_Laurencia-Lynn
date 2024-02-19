
// Concrete class for Motorcycle
class Motorcycle extends Vehicle {
    private String motorcycleType; // Automatic, Manual
    private int helmetPrice; // New variable for helmet price

    // Constructor
    public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String motorcycleType, int helmetPrice) {
        super("Motorcycle", brand, name, licenseNumber, topSpeed, gasCap, wheel);
        this.motorcycleType = motorcycleType;
        this.helmetPrice = helmetPrice;
    }

    // Override abstract method
    @Override
    void additionalInfo() {
        System.out.println("Motorcycle Type: " + motorcycleType);
        System.out.println("Helmet Price: " + helmetPrice);
    }

    // Getter method for helmet price
    public int getHelmetPrice() {
        return helmetPrice;
    }
}
