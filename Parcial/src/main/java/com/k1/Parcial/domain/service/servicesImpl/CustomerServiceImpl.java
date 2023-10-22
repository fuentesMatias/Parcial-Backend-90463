package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.infrastructure.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return Optional.of(customerRepository.getById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public Optional<Customer> update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
