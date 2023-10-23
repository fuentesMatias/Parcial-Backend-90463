package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.application.request.Invoice.InvoicePostDto;
import com.k1.Parcial.application.request.Invoice.InvoiceUpdateDto;
import com.k1.Parcial.domain.repository.InvoiceRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceService;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final CustomerService customerService;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerService customerService) {
        this.invoiceRepository = invoiceRepository;
        this.customerService = customerService;
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }

    @Override
    public Optional<Invoice> getById(Long id) {
        return Optional.of(invoiceRepository.getById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        invoiceRepository.delete(id);
    }

    @Override
    public Optional<Invoice> update(Invoice invoice) {
        return Optional.empty();
    }

    @Override
    public Invoice save(Invoice entity) {
        return null;
    }

    @Override
    public Invoice save(InvoicePostDto invoiceDto) {

        Customer customer = customerService.getById(invoiceDto.getCustomerId()).get();
        Invoice invoice = new Invoice(invoiceDto,customer);

        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<Invoice> update(Long id, InvoiceUpdateDto invoiceDto) {
        Customer customer = customerService.getById(id).get();

        Invoice invoice = new Invoice(invoiceDto,customer);

        return invoiceRepository.update(id,invoice);
    }
}
