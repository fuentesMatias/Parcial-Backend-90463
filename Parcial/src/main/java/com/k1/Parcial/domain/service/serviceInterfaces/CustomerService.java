package com.k1.Parcial.domain.service.serviceInterfaces;

import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.application.request.Customer.CustomerUpdateDto;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.infrastructure.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAll();

    Optional<Customer> getById(Long id) throws ServiceException;

    void delete(Long id);

    Customer save(CustomerPostDto entity);

    Optional<Customer> update(Long id,CustomerUpdateDto entity);
}
