package model;
public class Car {
    String color;
    String manufacturer;
    String modelName;
    String VIN;
    int year;
    double price;
    boolean isUsed;

    public Car(String VIN, String manufacturer, String modelName, String color, int year, double price, boolean isUsed) {
        this.VIN = VIN;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.color = color;
        this.year = year;
        this.price = price;
        this.isUsed = isUsed;
    }

    public String getColor(){
        return color;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public String getModelName(){
        return modelName;
    }

    public String getVIN(){
        return VIN;
    }

    public int getYear(){
        return year;
    }

    public double getPrice(){
        return price;
    }

    public boolean getIsUsed(){
        return isUsed;
    }

    @Override
    public String toString(){
        return "Car [VIN=" + VIN + ", manufacturer=" + manufacturer + ", modelName=" + modelName + ", color=" + color +
                ", year=" + year + ", price=" + price + ", isUsed=" + isUsed + "]";
    }
}



