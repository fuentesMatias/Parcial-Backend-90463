package com.k1.Parcial.domain.service.servicesImpl;


import com.k1.Parcial.domain.repository.InvoiceItemRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceItemService;
import com.k1.Parcial.infrastructure.entity.InvoiceItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private final InvoiceItemRepository invoiceItemRepository;

    public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository) {
        this.invoiceItemRepository = invoiceItemRepository;
    }

    @Override
    public List<InvoiceItem> getAll() {
        return invoiceItemRepository.getAll();
    }

    @Override
    public Optional<InvoiceItem> getById(Long id) {
        return Optional.of(invoiceItemRepository.getById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        invoiceItemRepository.delete(id);
    }

    @Override
    public Optional<InvoiceItem> update(InvoiceItem invoiceItem) {
        return Optional.of(invoiceItemRepository.update(invoiceItem).orElseThrow());
    }

    @Override
    public InvoiceItem save(InvoiceItem invoiceItem) {
        return invoiceItemRepository.save(invoiceItem);
    }
}
