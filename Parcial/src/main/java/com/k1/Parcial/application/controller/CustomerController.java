package com.k1.Parcial.application.controller;


import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.infrastructure.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @RequestMapping
    public ResponseEntity<?> getAllCustomers(){
        try {
            return ResponseEntity.ok().body(customerService.getAll());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.status(200).body(customerService.getById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

//    @DeleteMapping
//    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
//        try {
//            customerService.delete(id);
//            return ResponseEntity.ok().body("Customer deleted");
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(404).body(e.getMessage());
//        }
//    }

    @PostMapping
    public ResponseEntity<?> registrarCustomer(@RequestBody Customer customer){
        try {
            return ResponseEntity.ok().body(customerService.save(customer));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarCustomer(@RequestBody Customer customer){
        try {
            return ResponseEntity.ok().body(customerService.update(customer).get());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }



}
