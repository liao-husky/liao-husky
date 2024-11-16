package Campus;

import java.util.ArrayList;
import java.util.List;

public class Campus {
    private String name;
    private Address address;
    private List<Building> buildings;

    public Campus(String name, Address address) {
        this.name = name;
        this.address = address;
        this.buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public boolean isSafe() {
        for (Building building : buildings) {
            if (!building.isSafe()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Campus: " + name + ", Address: " + address;
    }
}
