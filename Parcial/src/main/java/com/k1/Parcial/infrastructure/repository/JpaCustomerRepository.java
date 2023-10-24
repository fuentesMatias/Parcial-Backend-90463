package com.k1.Parcial.infrastructure.repository;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.infrastructure.dao.DaoCustomer;
import com.k1.Parcial.infrastructure.entity.Customer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
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
            // Obtener todos los campos de la clase Customer
            Field[] fields = customerNewData.getClass().getDeclaredFields();
            // Recorre todos los field de la clase CustomerNewData y los setea en el customerToUpdate los que no son null
            for (int i = 1; i < fields.length; i++) {
                try {
                    Field field = fields[i];
                    field.setAccessible(true);
                    Object value = field.get(customerNewData);
                    if (value != null) {
                        field.set(customerToUpdate.get(), value);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }


            daoCustomer.save(customerToUpdate.get());
        }

        return customerToUpdate;
    }

    @Override
    public Customer save(Customer customer) {
        return daoCustomer.save(customer);
    }

}
