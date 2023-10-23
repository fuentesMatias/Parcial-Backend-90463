package com.k1.Parcial.infrastructure.entity;
//CREATE TABLE "invoices"
//        (
//        [InvoiceId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
//        [CustomerId] INTEGER  NOT NULL,
//        [InvoiceDate] DATETIME  NOT NULL,
//        [BillingAddress] NVARCHAR(70),
//        [BillingCity] NVARCHAR(40),
//        [BillingState] NVARCHAR(40),
//        [BillingCountry] NVARCHAR(40),
//        [BillingPostalCode] NVARCHAR(10),
//        [Total] NUMERIC(10,2)  NOT NULL,
//        FOREIGN KEY ([CustomerId]) REFERENCES "customers" ([CustomerId])
//        ON DELETE NO ACTION ON UPDATE NO ACTION
//        );

import com.k1.Parcial.application.request.Invoice.InvoicePostDto;
import com.k1.Parcial.application.request.Invoice.InvoiceUpdateDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "invoices")
@Data
@NoArgsConstructor

public class Invoice {

            @Id
            @GeneratedValue(generator = "invoices")
            @TableGenerator(name = "invoices", table = "sqlite_sequence",
                    pkColumnName = "name", valueColumnName = "seq",
                    pkColumnValue="invoices",
                    initialValue=1, allocationSize=1)
            @Column(name = "InvoiceId")
            private long id;

            @ManyToOne
            @JoinColumn(name = "CustomerId")
            private Customer customer;

            @Column(name = "InvoiceDate")
            private Date invoiceDate;

            @Column(name = "BillingAddress")
            private String billingAddress;

            @Column(name = "BillingCity")
            private String billingCity;

            @Column(name = "BillingState")
            private String billingState;

            @Column(name = "BillingCountry")
            private String billingCountry;

            @Column(name = "BillingPostalCode")
            private String billingPostalCode;

            @Column(name = "Total")
            private double total;

    public Invoice(InvoicePostDto invoiceDto, Customer customer) {

        this.invoiceDate = invoiceDto.getInvoiceDate();
        this.billingAddress = invoiceDto.getBillingAddress();
        this.billingCity = invoiceDto.getBillingCity();
        this.billingState = invoiceDto.getBillingState();
        this.billingCountry = invoiceDto.getBillingCountry();
        this.billingPostalCode = invoiceDto.getBillingPostalCode();
        this.total = invoiceDto.getTotal();
        this.customer = customer;

    }

    public Invoice(InvoiceUpdateDto invoiceDto, Customer customer) {

        this.invoiceDate = invoiceDto.getInvoiceDate();
        this.billingAddress = invoiceDto.getBillingAddress();
        this.billingCity = invoiceDto.getBillingCity();
        this.billingState = invoiceDto.getBillingState();
        this.billingCountry = invoiceDto.getBillingCountry();
        this.billingPostalCode = invoiceDto.getBillingPostalCode();
        this.total = invoiceDto.getTotal();
        this.customer = customer;

    }
}
