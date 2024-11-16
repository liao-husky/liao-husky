package Campus;

public class Sprinkler {
    private boolean active;
    private String maintenanceDate;

    public Sprinkler(boolean active, String maintenanceDate) {
        this.active = active;
        this.maintenanceDate = maintenanceDate;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Sprinkler [active=" + active + ", maintenanceDate=" + maintenanceDate + "]";
    }
}