package com.k1.Parcial.application.controller;


import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceService;
import com.k1.Parcial.infrastructure.entity.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.ok().body(invoiceService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(200).body(invoiceService.getById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id){
        try {
            invoiceService.delete(id);
            return ResponseEntity.ok().body("Invoice deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarInvoice(@RequestBody Invoice invoice){
        try {
            return ResponseEntity.ok().body(invoiceService.save(invoice));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarInvoice(@RequestBody Invoice invoice){
        try {
            return ResponseEntity.ok().body(invoiceService.update(invoice).get());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
