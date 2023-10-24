package com.k1.Parcial.domain.service.servicesImpl;


import com.k1.Parcial.application.request.InvoiceItem.InvoiceItemRequestDto;
import com.k1.Parcial.domain.repository.InvoiceItemRepository;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceItemService;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceService;
import com.k1.Parcial.domain.service.serviceInterfaces.TrackService;
import com.k1.Parcial.infrastructure.entity.Invoice;
import com.k1.Parcial.infrastructure.entity.InvoiceItem;
import com.k1.Parcial.infrastructure.entity.Track;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceService invoiceService;
    private final TrackService trackService;

    public InvoiceItemServiceImpl(InvoiceItemRepository invoiceItemRepository, InvoiceService invoiceService, TrackService trackService) {
        this.invoiceItemRepository = invoiceItemRepository;
        this.invoiceService = invoiceService;
        this.trackService = trackService;
    }

    @Override
    public List<InvoiceItem> getAll() {
        return invoiceItemRepository.getAll();
    }

    @Override
    public Optional<InvoiceItem> getById(Long id)  {
        if (id == null) throw new RuntimeException("El id no puede ser nulo");
        return Optional.of(invoiceItemRepository.getById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        invoiceItemRepository.delete(id);
    }

    @Override
    public InvoiceItem save(InvoiceItemRequestDto invoiceItemDto) {

        Track track = trackService.getById(invoiceItemDto.getTrackId()).get();

        Invoice invoice = invoiceService.getById(invoiceItemDto.getInvoiceId()).get();

        InvoiceItem invoiceItem = new InvoiceItem(invoiceItemDto,invoice,track);

        return invoiceItemRepository.save(invoiceItem);
    }

    @Override
    public InvoiceItem update(Long id, InvoiceItemRequestDto invoiceItemDto) {
        InvoiceItem invoiceItem;
        Track track = null;
        Invoice invoice = null;
        if (invoiceItemDto.getTrackId() != 0) {
            track = trackService.getById(invoiceItemDto.getTrackId()).get();
        }
        if (invoiceItemDto.getInvoiceId() != 0) {
            invoice = invoiceService.getById(invoiceItemDto.getInvoiceId()).get();
        }
        invoiceItem = new InvoiceItem(invoiceItemDto, invoice,track);

        return invoiceItemRepository.update(id, invoiceItem).get();
    }
}

