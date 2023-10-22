package com.k1.Parcial.application.controller;


import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceItemService;
import com.k1.Parcial.infrastructure.entity.InvoiceItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoiceItem")
public class InvoiceItemController {

    private final InvoiceItemService invoiceItemService;

    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    @GetMapping
    public ResponseEntity<?> getAllInvoiceItems(){
        try {
            return ResponseEntity.ok().body(invoiceItemService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceItemById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(200).body(invoiceItemService.getById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarInvoiceItem(@RequestBody InvoiceItem invoiceItem){
        try {
            return ResponseEntity.ok().body(invoiceItemService.save(invoiceItem));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteInvoiceItem(@PathVariable("id") Long id){
        try {
            invoiceItemService.delete(id);
            return ResponseEntity.ok().body("InvoiceItem deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarInvoiceItem(@RequestBody InvoiceItem invoiceItem){
        try {
            return ResponseEntity.ok().body(invoiceItemService.update(invoiceItem).get());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
