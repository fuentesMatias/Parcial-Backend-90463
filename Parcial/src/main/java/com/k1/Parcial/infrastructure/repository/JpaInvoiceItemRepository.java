package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.repository.InvoiceItemRepository;
import com.k1.Parcial.infrastructure.dao.DaoCustomer;
import com.k1.Parcial.infrastructure.dao.DaoInvoiceItem;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.InvoiceItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JpaInvoiceItemRepository implements InvoiceItemRepository {

    private final DaoInvoiceItem daoInvoiceItem;

    public JpaInvoiceItemRepository(DaoInvoiceItem daoInvoiceItem) {
        this.daoInvoiceItem = daoInvoiceItem;
    }


    @Override
    public List<InvoiceItem> getAll() {
        return daoInvoiceItem.findAll();
    }

    @Override
    public Optional<InvoiceItem> getById(Long id) {
        return daoInvoiceItem.findById(id);
    }

    @Override
    public void delete(Long id) {
        daoInvoiceItem.deleteById(id);
    }

    @Override
    public Optional<InvoiceItem> update(Long id,InvoiceItem invoiceItem) {
        Optional<InvoiceItem> invoiceItemToUpdate = daoInvoiceItem.findById(id);
        if (invoiceItemToUpdate.isPresent()) {
            invoiceItemToUpdate.get().setInvoice(invoiceItem.getInvoice());
            invoiceItemToUpdate.get().setTrack(invoiceItem.getTrack());
            invoiceItemToUpdate.get().setUnitPrice(invoiceItem.getUnitPrice());
            invoiceItemToUpdate.get().setQuantity(invoiceItem.getQuantity());
            daoInvoiceItem.save(invoiceItemToUpdate.get());
        }else {
            Throwable e = new Throwable("InvoiceItem not found");
        }
        return invoiceItemToUpdate;
    }

    @Override
    public InvoiceItem save(InvoiceItem invoiceItem) {
        return daoInvoiceItem.save(invoiceItem);
    }
}
