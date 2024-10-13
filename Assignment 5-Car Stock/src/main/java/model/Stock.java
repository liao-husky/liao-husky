package model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    ArrayList<Car> carStock;
    public Object findCarsBysrc;

    public Stock() {
        carStock = new ArrayList<Car>();
    }

    public void addCar(Car car){
        carStock.add(car);
    }

    public Car findCarByVIN(String VIN){
        for(Car car:carStock){
            if(car.getVIN().equalsIgnoreCase(VIN)){
                return car;
            }
        }
        return null;
    }

    public List<Car> findCarsByManufacturerAndModel(String manufacturer, String modelName){
        List<Car> foundCars = new ArrayList<>();
        for (Car car : carStock) {
            if (car.getManufacturer().equalsIgnoreCase(manufacturer) && car.getModelName().equalsIgnoreCase(modelName)) {
                foundCars.add(car);
            }
        }
        return foundCars;
    }

    public List<Car> getCarStock() {
        return carStock;
    }
}