package Campus;

public class Address {
    private String buildingNumber;
    private String street;
    private String zipCode;
    private String gpsCoordinates;

    public Address(String buildingNumber, String street, String zipCode, String gpsCoordinates) {
        this.buildingNumber = buildingNumber;
        this.street = street;
        this.zipCode = zipCode;
        this.gpsCoordinates = gpsCoordinates;
    }

    @Override
    public String toString() {
        return buildingNumber + " " + street + ", ZIP: " + zipCode + ", GPS: " + gpsCoordinates;
    }
}