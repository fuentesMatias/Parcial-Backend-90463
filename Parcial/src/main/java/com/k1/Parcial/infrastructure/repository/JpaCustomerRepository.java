package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.infrastructure.dao.DaoCustomer;
import com.k1.Parcial.infrastructure.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaCustomerRepository implements CustomerRepository {

    private final DaoCustomer daoCustomer;

    public JpaCustomerRepository(DaoCustomer daoCustomer) {
        this.daoCustomer = daoCustomer;
    }
    @Override
    public List<Customer> getAll() {
        return daoCustomer.findAll();
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return daoCustomer.findById(id);
    }

    @Override
    public void delete(Long id) {
        daoCustomer.deleteById(id);
    }

    @Override
    public Optional<Customer> update(Customer customer) {
        Optional<Customer> customerToUpdate = daoCustomer.findById(customer.getId());
        if (customerToUpdate.isPresent()) {
            customerToUpdate.get().setFirstName(customer.getFirstName());
            customerToUpdate.get().setLastName(customer.getLastName());
            customerToUpdate.get().setCompany(customer.getCompany());
            customerToUpdate.get().setAddress(customer.getAddress());
            customerToUpdate.get().setCity(customer.getCity());
            customerToUpdate.get().setState(customer.getState());
            customerToUpdate.get().setCountry(customer.getCountry());
            customerToUpdate.get().setPostalCode(customer.getPostalCode());
            customerToUpdate.get().setPhone(customer.getPhone());
            customerToUpdate.get().setFax(customer.getFax());
            customerToUpdate.get().setEmail(customer.getEmail());
            daoCustomer.save(customerToUpdate.get());
        }
        return customerToUpdate;
    }

    @Override
    public Customer save(Customer customer) {
        return daoCustomer.save(customer);
    }
}
