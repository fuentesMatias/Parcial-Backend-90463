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
}
