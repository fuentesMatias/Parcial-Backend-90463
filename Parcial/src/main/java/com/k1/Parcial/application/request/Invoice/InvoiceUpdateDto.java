package com.k1.Parcial.application.request.Invoice;

import lombok.Data;

import java.util.Date;

@Data
public class InvoiceUpdateDto {
    private Date invoiceDate;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private double total;
    private long customerId;
}
