// Abstract class
abstract class Vehicle {
    // Properties
    protected String type;
    protected String brand;
    protected String name;
    protected String licenseNumber;
    protected int topSpeed;
    protected int gasCap;
    protected int wheel;

    // Constructor
    public Vehicle(String type, String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.topSpeed = topSpeed;
        this.gasCap = gasCap;
        this.wheel = wheel;
    }

    // Abstract method
    abstract void additionalInfo(); // untuk pertanyaan khusus

    // Display method
    public void displayInfo() {
        System.out.println("Type: " + type);
        System.out.println("Brand: " + brand);
        System.out.println("Name: " + name);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Top Speed: " + topSpeed + " km/h");
        System.out.println("Gas Cap: " + gasCap + " liters");
        System.out.println("Number of Wheels: " + wheel);
        additionalInfo();
    }

    // Metode getter untuk mendapatkan jenis kendaraan
    public String getType() {
        return type;
    }

    // Metode getter untuk mendapatkan nama kendaraan
    public String getName() {
        return name;
    }
}