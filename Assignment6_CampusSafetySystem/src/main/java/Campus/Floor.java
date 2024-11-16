package Campus;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<Classroom> classrooms;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.classrooms = new ArrayList<>();
    }

    public void addClassroom(Classroom classroom) {
        classrooms.add(classroom);
    }

    public boolean isSafe() {
        for (Classroom classroom : classrooms) {
            if (!classroom.isSafe()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Floor: " + floorNumber;
    }
}
