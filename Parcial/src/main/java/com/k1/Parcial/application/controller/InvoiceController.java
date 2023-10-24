package com.k1.Parcial.application.controller;


import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.application.request.Invoice.InvoicePostDto;
import com.k1.Parcial.application.request.Invoice.InvoiceUpdateDto;
import com.k1.Parcial.application.response.Invoice.InvoiceResponseDto;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceService;
import com.k1.Parcial.infrastructure.entity.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {

        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<?> getAllInvoices(){
        try {
            List<InvoiceResponseDto> responseDTOList = invoiceService.getAll().stream().map(InvoiceResponseDto::new).toList();
            return ResponseEntity.ok().body(responseDTOList);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable("id") Long id){
        try {
            InvoiceResponseDto responseDTO = new InvoiceResponseDto(invoiceService.getById(id).get());
            return ResponseEntity.status(200).body(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}") //TODO No usar
    public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id){
        try {
            invoiceService.delete(id);
            return ResponseEntity.ok().body("Invoice deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarInvoice(@RequestBody InvoicePostDto invoiceDto){
        try {
            return ResponseEntity.ok().body(invoiceService.save(invoiceDto).toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarInvoice(@PathVariable("id") Long id,@RequestBody InvoiceUpdateDto invoiceDto){
        try {
            return ResponseEntity.ok().body(invoiceService.update(id,invoiceDto).get().toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
