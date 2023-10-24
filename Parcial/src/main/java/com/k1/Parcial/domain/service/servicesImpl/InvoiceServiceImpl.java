package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.application.request.Invoice.InvoicePostDto;
import com.k1.Parcial.application.request.Invoice.InvoiceUpdateDto;
import com.k1.Parcial.domain.repository.InvoiceRepository;
import com.k1.Parcial.domain.service.ServiceException;
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
        if (id == null) throw new RuntimeException("El id no puede ser nulo");
        return Optional.of(invoiceRepository.getById(id).orElseThrow());

    }

    @Override
    public void delete(Long id) {
        invoiceRepository.delete(id);
    }

    @Override
    public Invoice save(InvoicePostDto invoiceDto) throws RuntimeException {

        try {
            Customer customer = customerService.getById(invoiceDto.getCustomerId()).get();
            Invoice invoice = new Invoice(invoiceDto,customer);
            return invoiceRepository.save(invoice);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Optional<Invoice> update(Long id, InvoiceUpdateDto invoiceDto) {
        Invoice invoice;
        if (invoiceDto.getCustomerId() == 0){
            invoice = new Invoice(invoiceDto);
        }else {
            Customer customer = customerService.getById(invoiceDto.getCustomerId()).get();

            invoice = new Invoice(invoiceDto, customer);
        }
        return invoiceRepository.update(id,invoice);
    }
}
