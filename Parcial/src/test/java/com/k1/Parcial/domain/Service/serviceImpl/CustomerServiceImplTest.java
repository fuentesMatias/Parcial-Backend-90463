package com.k1.Parcial.domain.Service.serviceImpl;

import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.domain.service.serviceInterfaces.EmployeService;
import com.k1.Parcial.domain.service.servicesImpl.CustomerServiceImpl;
import com.k1.Parcial.infrastructure.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private EmployeService employeService;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;


    @Test
    public void test_getAll_no_equal() {
        Customer customerSimulado = new Customer();
        customerSimulado.setId(13);
        customerSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer();
        customerEsperado.setId(12);
        customerEsperado.setFirstName("unNombre");
        customerEsperado.setLastName("unApellido");

        Mockito.when(customerRepository.getAll()).thenReturn(List.of(customerSimulado));
        Customer customer = customerServiceImpl.getAll().iterator().next(); //Obtengo el primer elemento de la lista
        Assertions.assertNotEquals(customerEsperado, customer);
        Mockito.verify(customerRepository).getAll();//Verifico que fue llamado una vez el metodo
    }

    @Test
    public void test_getAll_equal() {
        Customer customerSimulado = new Customer();
        customerSimulado.setId(13);
        customerSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer();
        customerEsperado.setId(13);
        customerEsperado.setFirstName("unNombre2");

        Mockito.when(customerRepository.getAll()).thenReturn(List.of(customerSimulado));
        Customer customer = customerServiceImpl.getAll().iterator().next(); //Obtengo el primer elemento de la lista
        Assertions.assertEquals(customerEsperado, customer);
        Mockito.verify(customerRepository).getAll();//Verifico que fue llamado una vez el metodo
    }

    @Test
    public void test_getById_not_found(){
        Customer customerSimulado = new Customer();
        customerSimulado.setId(13);
        customerSimulado.setFirstName("unNombre2");


        Mockito.when(customerRepository.getById(13L)).thenReturn(java.util.Optional.of(customerSimulado));
        Assertions.assertThrows(RuntimeException.class, () -> {
            customerServiceImpl.getById(12L);
        });
        Mockito.verify(customerRepository).getById(12L);
    }

    @Test
    void test_getById_equal() throws ServiceException {
        Customer customerSimulado = new Customer();
        customerSimulado.setId(13);
        customerSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer();
        customerEsperado.setId(13);
        customerEsperado.setFirstName("unNombre2");

        Mockito.when(customerRepository.getById(13L)).thenReturn(java.util.Optional.of(customerSimulado));
        Customer customer = customerServiceImpl.getById(13L).get();
        Assertions.assertEquals(customerEsperado, customer);
        Mockito.verify(customerRepository).getById(13L);
    }



}
