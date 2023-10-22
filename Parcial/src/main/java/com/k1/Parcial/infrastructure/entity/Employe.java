package com.k1.Parcial.infrastructure.entity;

//CREATE TABLE "employees"
//        (
//        [EmployeeId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
//        [LastName] NVARCHAR(20)  NOT NULL,
//        [FirstName] NVARCHAR(20)  NOT NULL,
//        [Title] NVARCHAR(30),
//        [ReportsTo] INTEGER,
//        [BirthDate] DATETIME,
//        [HireDate] DATETIME,
//        [Address] NVARCHAR(70),
//        [City] NVARCHAR(40),
//        [State] NVARCHAR(40),
//        [Country] NVARCHAR(40),
//        [PostalCode] NVARCHAR(10),
//        [Phone] NVARCHAR(24),
//        [Fax] NVARCHAR(24),
//        [Email] NVARCHAR(60),
//        FOREIGN KEY ([ReportsTo]) REFERENCES "employees" ([EmployeeId])
//        ON DELETE NO ACTION ON UPDATE NO ACTION
//        );

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "employees")
@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Employe {

        @Id
        //@GeneratedValue(strategy = GenerationType.IDENTITY)
        @GeneratedValue(generator = "employees")
        @TableGenerator(name = "employees", table = "sqlite_sequence",
                pkColumnName = "name", valueColumnName = "seq",
                pkColumnValue="employees",
                initialValue=1, allocationSize=1)

        @Column(name = "EmployeeId")
        private long id;

        @Column(name = "LastName")
        private String lastName;

        @Column(name = "FirstName")
        private String firstName;

        @Column(name = "Title")
        private String title;

        @ManyToOne
        @JoinColumn(name = "ReportsTo")
        private Employe reportsTo;

        @Column(name = "BirthDate")
        private Date birthDate;

        @Column(name = "HireDate")
        private Date hireDate;

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
}
