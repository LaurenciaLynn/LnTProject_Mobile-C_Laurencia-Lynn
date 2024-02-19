import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        while (true) {
            System.out.println("PT ChipiChapa");
            System.out.println("1. Insert");
            System.out.println("2. View");
            System.out.println("3. Exit System");
            System.out.print("Choose option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    insertData(scanner, vehicles);
                    break;
                case 2:
                    viewData(scanner, vehicles);
                    break;
                case 3:
                    System.out.println("Exiting PT ChipiChapa System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }

    // buat Insert data method
    private static void insertData(Scanner scanner, List<Vehicle> vehicles) {
        while (true) {
            System.out.print("\nInput type [Car | Motorcycle]: ");
            String vehicleType = scanner.nextLine();

            if (vehicleType.equalsIgnoreCase("Car")) {
                // For Car
                insertCarData(scanner, vehicles);
                
            } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
                // For Motorcycle
                insertMotorcycleData(scanner, vehicles);
            } else {
                System.out.println("Invalid vehicle type. Please enter 'Car' or 'Motorcycle'.");
            }

            System.out.print("\nENTER to return to main menu [enter '0' to exit]: ");
            String returnInput = scanner.nextLine();
            if (returnInput.equals("0")) {
                break;
            }
        }
    }

    //ini buat View data method
    private static void viewData(Scanner scanner, List<Vehicle> vehicles) {
        System.out.println("\nView Data:");
        System.out.println("No | Type        | Name");
        System.out.println("-----------------------------------");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + "  | " + vehicles.get(i).getType() + " | " + vehicles.get(i).getName());
        }

        System.out.print("\nPick a vehicle to test drive [enter '0' to return to main menu]: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (choice == 0) {
            return; // Return to main menu
        }

        if (choice >= 1 && choice <= vehicles.size()) {
            Vehicle selectedVehicle = vehicles.get(choice - 1);
            System.out.println("-----------------------------------");
            selectedVehicle.displayInfo();

            if (selectedVehicle instanceof Car) {
                Car selectedCar = (Car) selectedVehicle;
                selectedCar.turnOnEntertainmentSystem();
                if (selectedCar.getType().equals("Supercar")) {
                    System.out.println("Boosting!");
                }
            } else if (selectedVehicle instanceof Motorcycle) {
                Motorcycle selectedMotorcycle = (Motorcycle) selectedVehicle;
                System.out.println(selectedMotorcycle.getName() + " is standing!");
                System.out.println("Helmet Price: " + selectedMotorcycle.getHelmetPrice());
            }
        } else {
            System.out.println("Invalid choice. Please enter a valid number.");
        }
    }

    // Helper method to insert Car data
    private static void insertCarData(Scanner scanner, List<Vehicle> vehicles) {
        System.out.print("Brand: ");
        String brand = validateInput("Brand", 5, scanner);
        scanner.nextLine();

        System.out.print("Name: ");
        String name = validateInput("Name", 5, scanner);

        System.out.print("License Number: ");
        String licenseNumber = validateLicenseNumber(scanner);

        System.out.print("Top Speed: ");
        int topSpeed = validateInputRange("Top Speed", 100, 250, scanner);

        System.out.print("Gas Cap: ");
        int gasCap = validateInputRange("Gas Cap", 30, 60, scanner);

        System.out.print("Number of Wheels: ");
        int wheel = validateInputRange("Wheel", 4, 6, scanner);

        System.out.println("Choose Car Type: ");
        System.out.println("1. SUV");
        System.out.println("2. Supercar");
        System.out.println("3. Minivan");
        System.out.print("Enter choice (1-3): ");
        int carTypeChoice = scanner.nextInt();
        scanner.nextLine(); // supaya kalau klik enter ga error

        String carType = "";
        switch (carTypeChoice) {
            case 1:
                carType = "SUV";
                break;
            case 2:
                carType = "Supercar";
                break;
            case 3:
                carType = "Minivan";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to SUV.");
                carType = "SUV";
        }

        // Input specific data for Car
        int entertainmentSystemCount;
        do {
            System.out.print("Input entertainment system amount [>= 1]: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            entertainmentSystemCount = scanner.nextInt();
            if (entertainmentSystemCount < 1) {
                System.out.println("Entertainment System Count should be at least 1.");
            }
        } while (entertainmentSystemCount < 1);

        // bikin Car object
        Car car = new Car(brand, name, licenseNumber, topSpeed, gasCap, wheel, carType, entertainmentSystemCount);
        vehicles.add(car);
    }

    //  method buat insert Motorcycle data
    private static void insertMotorcycleData(Scanner scanner, List<Vehicle> vehicles) {
        System.out.print("Brand: ");
        String brand = validateInput("Brand", 5, scanner);

        System.out.print("Name: ");
        String name = validateInput("Name", 5, scanner);

        System.out.print("License Number: ");
        String licenseNumber = validateLicenseNumber(scanner);

        System.out.print("Top Speed: ");
        int topSpeed = validateInputRange("Top Speed", 100, 250, scanner);

        System.out.print("Gas Cap: ");
        int gasCap = validateInputRange("Gas Cap", 30, 60, scanner);

        System.out.print("Number of Wheels: ");
        int wheel = validateInputRange("Wheel", 2, 3, scanner);

        System.out.println("Choose Motorcycle Type: ");
        System.out.println("1. Automatic");
        System.out.println("2. Manual");
        System.out.print("Enter choice (1-2): ");
        int motorcycleTypeChoice = scanner.nextInt();
        scanner.nextLine(); 

        String motorcycleType = "";
        switch (motorcycleTypeChoice) {
            case 1:
                motorcycleType = "Automatic";
                break;
            case 2:
                motorcycleType = "Manual";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Automatic.");
                motorcycleType = "Automatic";
        }

        // Input specific data for Motorcycle
        System.out.print("Input helmet price [>= 1]: ");
        int helmetPrice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
            helmetPrice = scanner.nextInt();
            if (helmetPrice < 1) {
                System.out.println("Helmet Price should be at least 1.");
            }
        } while (helmetPrice < 1);

        // Create Motorcycle object
        Motorcycle motorcycle = new Motorcycle(brand, name, licenseNumber, topSpeed, gasCap, wheel, motorcycleType, helmetPrice);
        vehicles.add(motorcycle);
    }

    // Helper method to validate input based on minimum length
    private static String validateInput(String inputType, int minLength, Scanner scanner) {
        String input;
        do {
            System.out.print(inputType + ": ");
            input = scanner.nextLine().trim();
            if (input.length() < minLength) {
                System.out.println("Minimum length for " + inputType + " is " + minLength + " characters.");
            }
        } while (input.length() < minLength);
        return input;
    }

    // Helper method to validate license number format
    private static String validateLicenseNumber(Scanner scanner) {
        String licenseNumber;
        do {
            System.out.print("License Number: ");
            licenseNumber = scanner.nextLine().trim();
            if (!licenseNumber.matches("^[A-Z]\\d{1,4} [A-Z]{1,3}$")) {
                System.out.println("Invalid license number format. Please follow the specified format.");
            }
        } while (!licenseNumber.matches("^[A-Z]\\d{1,4} [A-Z]{1,3}$"));
        return licenseNumber;
    }

    // Helper method to validate input within a specified range
    private static int validateInputRange(String inputType, int min, int max, Scanner scanner) {
        int inputValue;
        do {
            System.out.print(inputType + " (" + min + "-" + max + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
            inputValue = scanner.nextInt();
            if (inputValue < min || inputValue > max) {
                System.out.println("Input out of range. Please enter a value between " + min + " and " + max + ".");
            }
        } while (inputValue < min || inputValue > max);
        return inputValue;
    }
}
