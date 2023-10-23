package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.application.request.InvoiceItem.InvoiceItemRequestDto;
import com.k1.Parcial.infrastructure.entity.Invoice;
import com.k1.Parcial.infrastructure.entity.InvoiceItem;

import java.util.List;
import java.util.Optional;

public interface InvoiceItemService {
    List<InvoiceItem> getAll();

    Optional<InvoiceItem> getById(Long id);

    void delete(Long id);

    InvoiceItem save(InvoiceItemRequestDto invoiceItemDto);

    InvoiceItem update(Long id,InvoiceItemRequestDto invoiceItemDto);
}
