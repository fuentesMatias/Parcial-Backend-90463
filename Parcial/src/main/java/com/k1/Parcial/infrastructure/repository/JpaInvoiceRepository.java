package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.repository.InvoiceRepository;
import com.k1.Parcial.infrastructure.dao.DaoCustomer;
import com.k1.Parcial.infrastructure.dao.DaoInvoice;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaInvoiceRepository implements InvoiceRepository {

    private final DaoInvoice daoInvoice;

    public JpaInvoiceRepository(DaoInvoice daoInvoice) {
        this.daoInvoice = daoInvoice;
    }

    @Override
    public List<Invoice> getAll() {
        return daoInvoice.findAll();
    }

    @Override
    public Optional<Invoice> getById(Long id) {
        return daoInvoice.findById(id);
    }

    @Override
    public void delete(Long id) {
        daoInvoice.deleteById(id);
    }

    @Override
    public Optional<Invoice> update(Invoice invoice) {
        Optional<Invoice> invoiceToUpdate = daoInvoice.findById(invoice.getId());
        if (invoiceToUpdate.isPresent()) {
            invoiceToUpdate.get().setTotal(invoice.getTotal());
            invoiceToUpdate.get().setInvoiceDate(invoice.getInvoiceDate());
            daoInvoice.save(invoiceToUpdate.get());
        }
        return invoiceToUpdate;
    }

    @Override
    public Invoice save(Invoice invoice) {
        return daoInvoice.save(invoice);
    }
}
