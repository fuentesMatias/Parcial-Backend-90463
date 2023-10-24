package com.k1.Parcial.application.controller;


import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.application.request.Customer.CustomerUpdateDto;
import com.k1.Parcial.application.response.Customer.CustomerResponseDTO;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.domain.service.serviceInterfaces.EmployeService;
import com.k1.Parcial.infrastructure.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }
    @GetMapping
    public ResponseEntity<?> getAllCustomers(){
        try {
            List<CustomerResponseDTO> responseDTOList = customerService.getAll().stream().map(CustomerResponseDTO::new).toList();
            return ResponseEntity.ok().body(responseDTOList);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
        try {
            CustomerResponseDTO responseDTO = new CustomerResponseDTO(customerService.getById(id).get());
            return ResponseEntity.status(200).body(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }catch (ServiceException e){
            return ResponseEntity.status(402).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        try {
            customerService.delete(id);
            return ResponseEntity.ok().body("Customer deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> registrarCustomer(@RequestBody CustomerPostDto customerDto){
        try {
            Customer customer = customerService.save(customerDto);
            //Logica de validacion si pidiera hacerse
            if (customer.getSupportRepId().getCity() == null) {
                return ResponseEntity.status(204).body(customer.toCustomerResponseDTO());
            }
            return ResponseEntity.ok().body(customer.toCustomerResponseDTO());
        } catch (RuntimeException | ServiceException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCustomer(@PathVariable Long id,@RequestBody CustomerUpdateDto customerDto){
        try {
            return ResponseEntity.ok().body(customerService.update(id,customerDto).get().toCustomerResponseDTO());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }



}
