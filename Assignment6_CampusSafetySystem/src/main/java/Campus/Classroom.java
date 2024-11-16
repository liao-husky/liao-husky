package Campus;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private int roomNumber;
    private Sprinkler sprinkler;
    private List<Seat> seats;

    public Classroom(int roomNumber, Sprinkler sprinkler) {
        this.roomNumber = roomNumber;
        this.sprinkler = sprinkler;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public boolean isSafe() {
        return sprinkler.isActive();
    }

    @Override
    public String toString() {
        return "Classroom " + roomNumber + ", Sprinkler Status: " + (sprinkler.isActive() ? "Active" : "Inactive");
    }
}
