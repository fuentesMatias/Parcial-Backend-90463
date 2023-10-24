package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.service.servicesImpl.MetodosComunes;
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
    public Optional<Customer> update(Long id, Customer customerNewData) {

        Optional<Customer> customerToUpdate = daoCustomer.findById(id);


        if (customerToUpdate.isPresent()) {
            Customer updateCustomer = MetodosComunes.noUpdateToFieldsNull(customerNewData,customerToUpdate.get());
            daoCustomer.save(updateCustomer);
        }

        return customerToUpdate;
    }

    @Override
    public Customer save(Customer customer) {
        return daoCustomer.save(customer);
    }

}
