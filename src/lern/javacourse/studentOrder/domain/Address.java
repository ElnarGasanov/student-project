package lern.javacourse.studentOrder.domain;

public class Address {
    private String city;
    private String street;
    private String building;
    private String appartment;
    private String postCode;

    public Address(String postCode, String street, String building, String city, String appartment) {
        this.postCode = postCode;
        this.street = street;
        this.building = building;
        this.city = city;
        this.appartment = appartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
