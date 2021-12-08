public class Address {
    int streetNumber;
    String streetName;
    String city;
    String province;
    String postalCode;


    String tostring() {
        return "Street Number: " + streetNumber + "\n" + "Street Name: " + streetName + "\n" + "City: " + city + "\n" + "Province: " + province + "\n" + "Postal Code: " + postalCode;
    }
}