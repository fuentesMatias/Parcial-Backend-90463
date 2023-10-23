package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.application.request.Customer.CustomerUpdateDto;
import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.domain.service.serviceInterfaces.EmployeService;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Employe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final EmployeService employeService;

    public CustomerServiceImpl(CustomerRepository customerRepository, EmployeService employeService) {
        this.customerRepository = customerRepository;
        this.employeService = employeService;
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
    public Optional<Customer> update(Customer entity) {
        return Optional.empty();
    }


    @Override
    public Customer save(Customer entity) {
        return null;
    }


    @Override
    public Customer save(CustomerPostDto customerDto) {
        Employe employe = employeService.getById(customerDto.getSupportRepId()).get();

        Customer customer = new Customer(customerDto,employe);
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> update(Long id,CustomerUpdateDto entity) {
        Employe employe = employeService.getById(entity.getSupportRepId()).get();

        Customer customer = new Customer(entity,employe);

        return customerRepository.update(id,customer);
    }
}
