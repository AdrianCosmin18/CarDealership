package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer extends Person {

    private String phone;
    private String address;
    private String city;
    private String country;

    public Customer(String lastName, String firstName, String phone, String address, String city, String country) {
        super(lastName, firstName);
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
