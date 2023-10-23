package com.k1.Parcial.application.request.InvoiceItem;

import lombok.Data;

@Data
public class InvoiceItemRequestDto {
    private long invoiceId;
    private long trackId;
    private double unitPrice;
    private int quantity;
}
