package com.k1.Parcial.infrastructure.entity;
//CREATE TABLE "invoice_items"
//        (
//        [InvoiceLineId] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
//        [InvoiceId] INTEGER  NOT NULL,
//        [TrackId] INTEGER  NOT NULL,
//        [UnitPrice] NUMERIC(10,2)  NOT NULL,
//        [Quantity] INTEGER  NOT NULL,
//        FOREIGN KEY ([InvoiceId]) REFERENCES "invoices" ([InvoiceId])
//        ON DELETE NO ACTION ON UPDATE NO ACTION,
//        FOREIGN KEY ([TrackId]) REFERENCES "tracks" ([TrackId])
//        ON DELETE NO ACTION ON UPDATE NO ACTION
//        );

import com.k1.Parcial.application.request.InvoiceItem.InvoiceItemRequestDto;
import com.k1.Parcial.application.response.InvoiceItem.InvoiceItemReponseDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_items")
@Data
@NoArgsConstructor
public class InvoiceItem {

                @Id
                @GeneratedValue(generator = "invoice_items")
                @TableGenerator(name = "invoice_items", table = "sqlite_sequence",
                        pkColumnName = "name", valueColumnName = "seq",
                        pkColumnValue="invoice_items",
                        initialValue=1, allocationSize=1)
                @Column(name = "InvoiceLineId")
                private long id;

                @ManyToOne
                @JoinColumn(name = "InvoiceId")
                private Invoice invoice;

                @ManyToOne
                @JoinColumn(name = "TrackId")
                private Track track;

                @Column(name = "UnitPrice")
                private double unitPrice;

                @Column(name = "Quantity")
                private int quantity;

                public InvoiceItem(InvoiceItemRequestDto invoiceItemRequestDto, Invoice invoice, Track track) {
                    this.invoice = invoice;
                    this.track = track;
                    this.unitPrice = invoiceItemRequestDto.getUnitPrice();
                    this.quantity = invoiceItemRequestDto.getQuantity();
                }

    public InvoiceItem(InvoiceItemRequestDto invoiceItemDto) {
        this.unitPrice = invoiceItemDto.getUnitPrice();
        this.quantity = invoiceItemDto.getQuantity();
    }

    public InvoiceItem(InvoiceItemRequestDto invoiceItemDto, Track track) {
        this.track = track;
        this.unitPrice = invoiceItemDto.getUnitPrice();
        this.quantity = invoiceItemDto.getQuantity();
    }

    public InvoiceItem(InvoiceItemRequestDto invoiceItemDto, Invoice invoice) {
        this.invoice = invoice;
        this.unitPrice = invoiceItemDto.getUnitPrice();
        this.quantity = invoiceItemDto.getQuantity();
    }

    public InvoiceItemReponseDto toDto(){
                    return new InvoiceItemReponseDto(this);
                }
}
