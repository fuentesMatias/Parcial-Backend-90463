package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.application.request.Customer.CustomerUpdateDto;
import com.k1.Parcial.infrastructure.entity.Customer;

import java.util.Optional;

public interface CustomerService extends Service<Customer, Long> {

    Customer save(CustomerPostDto entity);

    Optional<Customer> update(Long id,CustomerUpdateDto entity);
}
