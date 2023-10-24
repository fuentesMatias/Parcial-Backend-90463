package com.k1.Parcial.application.controller;


import com.k1.Parcial.application.request.InvoiceItem.InvoiceItemRequestDto;
import com.k1.Parcial.application.response.InvoiceItem.InvoiceItemReponseDto;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceItemService;
import com.k1.Parcial.infrastructure.entity.InvoiceItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            List<InvoiceItemReponseDto> responseDTOList = invoiceItemService.getAll().stream().map(InvoiceItemReponseDto::new).toList();
            return ResponseEntity.ok().body(responseDTOList);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceItemById(@PathVariable("id") Long id){
        try {
            InvoiceItemReponseDto responseDTO = new InvoiceItemReponseDto(invoiceItemService.getById(id).get());
            return ResponseEntity.status(200).body(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarInvoiceItem(@RequestBody InvoiceItemRequestDto invoiceItemDto){
        try {

            return ResponseEntity.ok().body(invoiceItemService.save(invoiceItemDto).toDto());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarInvoiceItem(@PathVariable("id") Long id,@RequestBody InvoiceItemRequestDto invoiceItemDto){
        try {
            return ResponseEntity.ok().body(invoiceItemService.update(id,invoiceItemDto).toDto());
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
}
