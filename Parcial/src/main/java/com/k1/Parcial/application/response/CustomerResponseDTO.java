package com.k1.Parcial.application.response;

import com.k1.Parcial.infrastructure.entity.Customer;
import lombok.Data;

@Data
public class CustomerResponseDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
    private long supportRepId;

    public CustomerResponseDTO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.company = customer.getCompany();
        this.address = customer.getAddress();
        this.city = customer.getCity();
        this.state = customer.getState();
        this.country = customer.getCountry();
        this.postalCode = customer.getPostalCode();
        this.phone = customer.getPhone();
        this.fax = customer.getFax();
        this.email = customer.getEmail();

        if (customer.getSupportRepId() != null) {
            this.supportRepId = customer.getSupportRepId().getId();
        }
    }
}
