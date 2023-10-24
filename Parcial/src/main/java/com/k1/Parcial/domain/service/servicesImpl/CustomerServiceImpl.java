package com.k1.Parcial.domain.service.servicesImpl;

import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.application.request.Customer.CustomerUpdateDto;
import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.domain.service.serviceInterfaces.EmployeService;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Employe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

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
    public Optional<Customer> getById(Long id) throws ServiceException {
        Optional<Customer> customer = customerRepository.getById(id);
        if (customer.isPresent()) {
            return customer;
        } else {
            throw new ServiceException("Customer not found");
        }
    }

    @Override
    public void delete(Long id) {
        if (Objects.isNull(id)) throw new RuntimeException("El id no puede ser nulo");
        customerRepository.delete(id);

    }


    @Override
    public Customer save(CustomerPostDto customerDto) throws ServiceException {
        try {
            Employe employe = employeService.getById(customerDto.getSupportRepId()).get();
            Customer customer = new Customer(customerDto,employe);
            return customerRepository.save(customer);
        } catch (RuntimeException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Optional<Customer> update(Long id,CustomerUpdateDto dto) {
        Customer customer;
        if (dto.getSupportRepId() == 0){
             customer = new Customer(dto);
        }else{
            Employe employe = employeService.getById(dto.getSupportRepId()).get();
             customer = new Customer(dto,employe);
        }

        return customerRepository.update(id,customer);
    }
}
