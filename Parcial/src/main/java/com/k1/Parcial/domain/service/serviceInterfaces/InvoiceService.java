package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.application.request.Invoice.InvoicePostDto;
import com.k1.Parcial.application.request.Invoice.InvoiceUpdateDto;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService{
    List<Invoice> getAll();

    Optional<Invoice> getById(Long id);

    void delete(Long id);

    Invoice save(InvoicePostDto invoice) throws ServiceException;

    Optional<Invoice> update(Long id, InvoiceUpdateDto invoice) throws ServiceException;
}
