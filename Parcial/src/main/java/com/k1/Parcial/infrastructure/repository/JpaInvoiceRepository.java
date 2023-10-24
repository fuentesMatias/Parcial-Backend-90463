package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.InvoiceRepository;
import com.k1.Parcial.domain.service.servicesImpl.MetodosComunes;
import com.k1.Parcial.infrastructure.dao.DaoInvoice;
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
    public Optional<Invoice> update(Long id, Invoice invoiceNewData) {
        Optional<Invoice> invoiceToUpdate = daoInvoice.findById(id);

        if (invoiceToUpdate.isPresent()) {
            Invoice updatedInvoice = MetodosComunes.noUpdateToFieldsNull(invoiceNewData, invoiceToUpdate.get());
            daoInvoice.save(updatedInvoice);
        }

        return invoiceToUpdate;
    }


    @Override
    public Invoice save(Invoice invoice) {
        return daoInvoice.save(invoice);
    }
}
