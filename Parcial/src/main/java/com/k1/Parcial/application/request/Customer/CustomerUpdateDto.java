package com.k1.Parcial.application.request.Customer;

import lombok.Data;

@Data
public class CustomerUpdateDto {
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

    }
