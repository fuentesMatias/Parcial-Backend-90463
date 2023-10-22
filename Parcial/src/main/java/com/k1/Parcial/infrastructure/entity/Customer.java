package com.k1.Parcial.infrastructure.entity;

//CREATE TABLE "customers"
//        (
//        [CustomerId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
//        [FirstName] NVARCHAR(40)  NOT NULL,
//        [LastName] NVARCHAR(20)  NOT NULL,
//        [Company] NVARCHAR(80),
//        [Address] NVARCHAR(70),
//        [City] NVARCHAR(40),
//        [State] NVARCHAR(40),
//        [Country] NVARCHAR(40),
//        [PostalCode] NVARCHAR(10),
//        [Phone] NVARCHAR(24),
//        [Fax] NVARCHAR(24),
//        [Email] NVARCHAR(60)  NOT NULL,
//        [SupportRepId] INTEGER,
//        FOREIGN KEY ([SupportRepId]) REFERENCES "employees" ([EmployeeId])
//        ON DELETE NO ACTION ON UPDATE NO ACTION
//        );

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "customers")
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor

public class Customer {

            @Id
            @GeneratedValue(generator = "customers")
            @TableGenerator(name = "customers", table = "sqlite_sequence",
                    pkColumnName = "name", valueColumnName = "seq",
                    pkColumnValue="customers",
                    initialValue=1, allocationSize=1)
            @Column(name = "CustomerId")
            private long id;

            @Column(name = "FirstName")
            private String firstName;

            @Column(name = "LastName")
            private String lastName;

            @Column(name = "Company")
            private String company;

            @Column(name = "Address")
            private String address;

            @Column(name = "City")
            private String city;

            @Column(name = "State")
            private String state;

            @Column(name = "Country")
            private String country;

            @Column(name = "PostalCode")
            private String postalCode;

            @Column(name = "Phone")
            private String phone;

            @Column(name = "Fax")
            private String fax;

            @Column(name = "Email")
            private String email;

            @ManyToOne
            @JoinColumn(name = "SupportRepId")
            private Employe supportRepId;
}
