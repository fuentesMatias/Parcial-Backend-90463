package com.k1.Parcial.domain.repository;

import com.k1.Parcial.infrastructure.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {

    List<Invoice> getAll();

    Optional<Invoice> getById(Long id);

    void delete(Long id);

    Optional<Invoice> update(Long id,Invoice invoice);

    Invoice save(Invoice invoice);



}
