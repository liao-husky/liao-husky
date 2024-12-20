class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    public Address(String street,  String city,String state, String country, String postalCod){
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getCountry(){
        return country;
    }

    public String getPostalCode(){
        return postalCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + ", " + country + " - " + postalCode;
    }
}
