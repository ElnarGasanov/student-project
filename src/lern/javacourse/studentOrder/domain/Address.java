package lern.javacourse.studentOrder.domain;

public class Address {
    private String city;
    private Street street;
    private String building;
    private String apartment;
    private String postCode;
    private String extension;

    public Address(String postCode, Street street, String building, String city, String apartment) {
        this.postCode = postCode;
        this.street = street;
        this.building = building;
        this.city = city;
        this.apartment = apartment;
    }

    public Address() {
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
