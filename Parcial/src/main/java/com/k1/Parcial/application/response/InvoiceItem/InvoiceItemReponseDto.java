package com.k1.Parcial.application.response.InvoiceItem;


import com.k1.Parcial.infrastructure.entity.InvoiceItem;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceItemReponseDto {
    private long id;
    private long invoiceId;
    private long trackId;
    private double unitPrice;
    private int quantity;

    public InvoiceItemReponseDto(InvoiceItem invoiceItem) {
        this.id = invoiceItem.getId();
        this.invoiceId = invoiceItem.getInvoice().getId();
        this.trackId = invoiceItem.getTrack().getId();
        this.unitPrice = invoiceItem.getUnitPrice();
        this.quantity = invoiceItem.getQuantity();
    }
}
