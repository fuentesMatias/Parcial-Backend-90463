package com.k1.Parcial.domain.repository;

import com.k1.Parcial.infrastructure.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> getAll();

    Optional<Customer> getById(Long id);

    void delete(Long id);

    Optional<Customer> update(Customer customer);

    Customer save(Customer customer);


}
