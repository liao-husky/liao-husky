public class OwnerProfile {
    private String name;
    private String type;
    private Address address;
    private ContactInformation contactInformation;

    public OwnerProfile(String name, String type, Address address, ContactInformation contactInformation) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.contactInformation = contactInformation;
    }

    public String getName(){
        return type;
    }

    public String getType(){
        return type;
    }

    public Address getAddress(){
        return address;
    }

    public ContactInformation getContactInformation(){
        return contactInformation;
    }

    @Override
    public String toString() {
        return "Name: " + name + " (" + type + ")\n" + "Address: " + address + "\nContact: " + contactInformation;
    }
}
