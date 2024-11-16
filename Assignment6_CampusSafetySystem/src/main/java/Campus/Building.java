package Campus;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String buildingNumber;
    private Address address;
    private List<Floor> floors;

    public Building(String buildingNumber, Address address) {
        this.buildingNumber = buildingNumber;
        this.address = address;
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public boolean isSafe() {
        for (Floor floor : floors) {
            if (!floor.isSafe()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Building " + buildingNumber + ", Address: " + address;
    }
}
