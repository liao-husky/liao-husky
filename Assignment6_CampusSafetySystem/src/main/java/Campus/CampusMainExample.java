package Campus;

import Campus.Address;
import Campus.Building;
import Campus.Campus;
import Campus.Classroom;
import Campus.Floor;
import Campus.Sprinkler;

public class CampusMainExample {
    public static void main(String[] args) {
        // Step 0
        Address campusAddress = new Address("1", "Main St", "12345", "40.7128 N, 74.0060 W");
        Campus campus = new Campus("Green University", campusAddress);

        // Step 1
        Address building1Address = new Address("2", "Science Ave", "12345", "40.7128 N, 74.0061 W");
        Address building2Address = new Address("3", "Tech Blvd", "12345", "40.7128 N, 74.0062 W");

        Building building1 = new Building("Building 1", building1Address);
        Building building2 = new Building("Building 2", building2Address);

        campus.addBuilding(building1);
        campus.addBuilding(building2);

        // Step 2
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(1);
        Floor floor4 = new Floor(2);

        building1.addFloor(floor1);
        building1.addFloor(floor2);
        building2.addFloor(floor3);
        building2.addFloor(floor4);

        // Step 3
        Sprinkler sprinkler1 = new Sprinkler(true, "2024-01-10");
        Sprinkler sprinkler2 = new Sprinkler(false, "2023-12-05");

        Classroom classroom1 = new Classroom(101, sprinkler1);
        Classroom classroom2 = new Classroom(102, sprinkler2);
        Classroom classroom3 = new Classroom(201, sprinkler1);
        Classroom classroom4 = new Classroom(202, sprinkler2);

        floor1.addClassroom(classroom1);
        floor1.addClassroom(classroom2);
        floor2.addClassroom(classroom3);
        floor2.addClassroom(classroom4);

        // Step 4
        System.out.println("Is campus safe? " + (campus.isSafe() ? "Yes" : "No"));
    }
}