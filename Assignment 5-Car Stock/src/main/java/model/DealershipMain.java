package model;

import java.util.List;
import model.Car;
import model.Stock;

// Demo class to test the functionality
public class DealershipMain {
    public static void main(String[] args) {
        // Creating some Car objects
        Car car1 = new Car("H43J4EVXGFU64GQW1", "Toyota", "Camry", "Blue", 2021, 25000.0, true);
        Car car2 = new Car("K06WEA87CHNGTI07J", "Lexus", "Corolla", "Red", 2020, 20000.0, true);
        Car car3 = new Car("UOOZIMCNGAQROA2JP", "Honda", "Civic", "Black", 2019, 18000.0, false);
        Car car4 = new Car("35W7C92IRN0XUYCSW", "Hyundai", "Santa Fe", "White", 2021, 28000.0, true);

        // Creating the Stock object and adding cars to the stock
        Stock stock = new Stock();
        stock.addCar(car1);
        stock.addCar(car2);
        stock.addCar(car3);
        stock.addCar(car4);

        // Find a car by VIN
        Car foundCar = stock.findCarByVIN("H43J4EVXGFU64GQW1");
        if (foundCar != null) {
            System.out.println("Car found by VIN: " + foundCar);
        } else {
            System.out.println("Car with specified VIN not found.");
        }

        // Find cars by make and model
        List<Car> foundCars = stock.findCarsByManufacturerAndModel("Toyota", "Camry");
        System.out.println("Cars found by manufacturer and model:");
        for (Car car : foundCars) {
            System.out.println(car);
        }
    }
}