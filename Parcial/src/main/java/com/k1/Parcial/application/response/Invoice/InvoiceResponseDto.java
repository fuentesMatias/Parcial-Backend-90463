package com.k1.Parcial.application.response.Invoice;

import com.k1.Parcial.infrastructure.entity.Invoice;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceResponseDto {
    private long id;
    private String invoiceDate;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private double total;
    private long customerId;

    public InvoiceResponseDto(Invoice invoice) {
        this.id = invoice.getId();
        this.invoiceDate = invoice.getInvoiceDate().toString();
        this.billingAddress = invoice.getBillingAddress();
        this.billingCity = invoice.getBillingCity();
        this.billingState = invoice.getBillingState();
        this.billingCountry = invoice.getBillingCountry();
        this.billingPostalCode = invoice.getBillingPostalCode();
        this.total = invoice.getTotal();
        this.customerId = invoice.getCustomer().getId();


    }
}



