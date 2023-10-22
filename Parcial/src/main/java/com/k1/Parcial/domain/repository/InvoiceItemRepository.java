package com.k1.Parcial.domain.repository;

import com.k1.Parcial.infrastructure.entity.InvoiceItem;

import java.util.List;
import java.util.Optional;

public interface InvoiceItemRepository {

    List<InvoiceItem> getAll();

    Optional<InvoiceItem> getById(Long id);

    void delete(Long id);

    Optional<InvoiceItem> update(InvoiceItem invoiceItem);

    InvoiceItem save(InvoiceItem invoiceItem);



}
