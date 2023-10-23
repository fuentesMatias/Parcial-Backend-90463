package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.application.request.Invoice.InvoicePostDto;
import com.k1.Parcial.application.request.Invoice.InvoiceUpdateDto;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService extends Service<Invoice, Long>{

    Invoice save(InvoicePostDto invoice);

    Optional<Invoice> update(Long id, InvoiceUpdateDto invoice);
}
