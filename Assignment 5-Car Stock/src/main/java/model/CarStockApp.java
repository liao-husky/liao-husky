package model;

import java.util.List;

public class CarStockApp {
    public static void main(String[] args) {
        // Create an instance of Stock
        model.Stock stock = new model.Stock();

        // Create and add 15 different cars
        stock.addCar(new Car("1HGBH41JXMN109186", "Toyota", "Camry", "Blue", 2021, 25000.0, true));
        stock.addCar(new Car("1HGBH41JXMN109187", "Toyota", "Corolla", "Red", 2020, 20000.0, true));
        stock.addCar(new Car("2HGCM82633A004352", "Honda", "Civic", "Black", 2019, 18000.0, false));
        stock.addCar(new Car("5XYZT3LB5HG555236", "Hyundai", "Santa Fe", "White", 2021, 28000.0, true));
        stock.addCar(new Car("3VW2K7AJ0DM328142", "Volkswagen", "Jetta", "Gray", 2022, 22000.0, true));
        stock.addCar(new Car("1FTFW1EF9EFA44002", "Ford", "F-150", "Silver", 2021, 35000.0, true));
        stock.addCar(new Car("4T1BF1FK0GU189776", "Toyota", "Avalon", "Black", 2020, 40000.0, true));
        stock.addCar(new Car("1FADP3K21EL315862", "Ford", "Focus", "Red", 2018, 15000.0, false));
        stock.addCar(new Car("19UYA42772A012345", "Acura", "TLX", "Blue", 2022, 45000.0, true));
        stock.addCar(new Car("3FA6P0H73GR345678", "Ford", "Fusion", "Black", 2020, 22000.0, true));
        stock.addCar(new Car("WDDGF4HBXER290123", "Mercedes-Benz", "C-Class", "White", 2021, 42000.0, true));
        stock.addCar(new Car("1J4GA59118L594123", "Jeep", "Wrangler", "Green", 2021, 31000.0, true));
        stock.addCar(new Car("1FAHP3H25CL123456", "Ford", "Fiesta", "Yellow", 2019, 17000.0, false));
        stock.addCar(new Car("5NPEB4AC9DH123456", "Hyundai", "Sonata", "Silver", 2019, 21000.0, false));
        stock.addCar(new Car("3GCUKRECXFG567890", "Chevrolet", "Silverado", "Black", 2020, 40000.0, true));

        // Demonstrate searching by VIN
        String vinToSearch = "2HGCM82633A004352";
        Car foundCarByVIN = stock.findCarByVIN(vinToSearch);
        if (foundCarByVIN != null) {
            System.out.println("Car found by VIN (" + vinToSearch + "): " + foundCarByVIN);
        } else {
            System.out.println("No car found with VIN: " + vinToSearch);
        }

        // Demonstrate searching by Make and Model
        String makeToSearch = "Toyota";
        String modelToSearch = "Camry";
        List<Car> foundCarsByMakeModel = stock.findCarsByManufacturerAndModel(makeToSearch, modelToSearch);
        System.out.println("\nCars found by Make (" + makeToSearch + ") and Model (" + modelToSearch + "):");
        for (Car car : foundCarsByMakeModel) {
            System.out.println(car);
        }

        // Print out the whole list of cars in stock
        System.out.println("\nFull list of cars in stock:");
        for (Car car : stock.getCarStock()) {
            System.out.println(car);
        }
    }
}
