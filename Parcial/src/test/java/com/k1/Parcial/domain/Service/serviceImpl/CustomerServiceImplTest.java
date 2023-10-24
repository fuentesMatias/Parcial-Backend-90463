package com.k1.Parcial.domain.Service.serviceImpl;

import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.application.request.Customer.CustomerUpdateDto;
import com.k1.Parcial.domain.repository.CustomerRepository;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.domain.service.serviceInterfaces.EmployeService;
import com.k1.Parcial.domain.service.servicesImpl.CustomerServiceImpl;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Employe;
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private EmployeService employeService;
    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;


    @Test
    public void test_getAll_notEqual() {
        Customer customerSimulado = new Customer();
        customerSimulado.setId(13);
        customerSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer();
        customerEsperado.setId(12);
        customerEsperado.setFirstName("unNombre");
        customerEsperado.setLastName("unApellido");

        Mockito.when(customerRepository.getAll()).thenReturn(List.of(customerSimulado));
        List<Customer> customers = customerServiceImpl.getAll();

        // Verificar que la lista no esté vacía y que el primer elemento sea diferente a customerEsperado.
        assertFalse(customers.isEmpty());
        assertNotEquals(customerEsperado, customers.get(0));

        Mockito.verify(customerRepository).getAll(); // Verificar que el método se llamó una vez.
    }

    @Test
    public void test_getAll_equal() {
        // Crear un objeto simulado y un objeto esperado con los mismos valores.
        Customer customerSimulado = new Customer();
        customerSimulado.setId(13);
        customerSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer();
        customerEsperado.setId(13);
        customerEsperado.setFirstName("unNombre2");

        // Simular el repositorio para que devuelva el objeto simulado.
        Mockito.when(customerRepository.getAll()).thenReturn(List.of(customerSimulado));

        // Llamar al método del servicio.
        Customer customer = customerServiceImpl.getAll().iterator().next(); // Obtengo el primer elemento de la lista.

        // Verificar que el objeto retornado sea igual al objeto esperado.
        Assertions.assertEquals(customerEsperado, customer);

        // Verificar que el método se llamó una vez.
        Mockito.verify(customerRepository).getAll();
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

    @Test
    void test_delete() {
        Customer customerSimulado = new Customer();
        customerSimulado.setId(13);
        customerSimulado.setFirstName("unNombre2");

        Mockito.doNothing().when(customerRepository).delete(13L);
        customerServiceImpl.delete(13L);
        Mockito.verify(customerRepository).delete(13L);
    }

    @Test
    void test_delete_id_null() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            customerServiceImpl.delete(null);
        });
        Mockito.verifyNoInteractions(customerRepository);
    }

    //Test del metodo save
    @Test
    void test_save_success() throws ServiceException {
        CustomerPostDto customerSimulado = new CustomerPostDto();
        customerSimulado.setFirstName("unNombre2");
        customerSimulado.setSupportRepId(1L);

        Employe employeSimulado = new Employe();
        employeSimulado.setId(1L);
        employeSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer();
        //Lo seteamos en cero porque en realidad quien se encarga de asignarle un id es la base de datos
        //Y el Long cuando no se lo declara se coloca automaticamente en cero
        customerEsperado.setId(0);
        customerEsperado.setFirstName("unNombre2");
        customerEsperado.setSupportRepId(employeSimulado);

        Mockito.when(employeService.getById(1L)).thenReturn(Optional.of(employeSimulado));
        Mockito.when(customerRepository.save(customerEsperado)).thenReturn(customerEsperado);
        Customer customer = customerServiceImpl.save(customerSimulado);
        Assertions.assertEquals(customerEsperado, customer);

    }

    @Test
    void test_save_unsuccess_diff() throws ServiceException {
        CustomerPostDto customerSimulado = new CustomerPostDto();
        customerSimulado.setFirstName("unNombre2");
        customerSimulado.setSupportRepId(1L);

        Employe employeSimulado = new Employe();
        employeSimulado.setId(1L);
        employeSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer();
        customerEsperado.setId(0);
        customerEsperado.setFirstName("unNombre2");
        customerEsperado.setSupportRepId(employeSimulado);

        Customer customerOtro = new Customer();
        customerOtro.setId(1);
        customerOtro.setFirstName("unNombre2");
        customerOtro.setSupportRepId(employeSimulado);

        Mockito.when(employeService.getById(1L)).thenReturn(Optional.of(employeSimulado));
        Mockito.when(customerRepository.save(customerEsperado)).thenReturn(customerOtro);
        Customer customer = customerServiceImpl.save(customerSimulado);
        Assertions.assertNotEquals(customerEsperado, customer);

    }

    @Test
    void test_update_success(){
        CustomerUpdateDto customerSimulado = new CustomerUpdateDto();
        customerSimulado.setFirstName("unNombre2");
        customerSimulado.setSupportRepId(1L);

        Employe employeSimulado = new Employe();
        employeSimulado.setId(1L);
        employeSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer(customerSimulado,employeSimulado);


        Mockito.when(employeService.getById(1L)).thenReturn(Optional.of(employeSimulado));
        Mockito.when(customerRepository.update(12L,customerEsperado)).thenReturn(Optional.of(customerEsperado));

        Customer customer = customerServiceImpl.update(12L,customerSimulado).get();
        Assertions.assertEquals(customerEsperado, customer);
        Mockito.verify(customerRepository).update(12L,customerEsperado);
        Mockito.verify(employeService).getById(1L);


    }

    @Test
    void test_update_unsuccess(){
        CustomerUpdateDto customerSimulado = new CustomerUpdateDto();
        customerSimulado.setFirstName("unNombre2");
        customerSimulado.setSupportRepId(1L);

        Employe employeSimulado = new Employe();
        employeSimulado.setId(1L);
        employeSimulado.setFirstName("unNombre2");

        Customer customerEsperado = new Customer(customerSimulado,employeSimulado);
        Customer customerOtro = new Customer();
        customerOtro.setId(1);
        customerOtro.setFirstName("unNombre2");


        Mockito.when(employeService.getById(1L)).thenReturn(Optional.of(employeSimulado));
        Mockito.when(customerRepository.update(12L,customerEsperado)).thenReturn(Optional.of(customerOtro));

        Customer customer = customerServiceImpl.update(12L,customerSimulado).get();
        Assertions.assertNotEquals(customerEsperado, customer);
        Mockito.verify(customerRepository).update(12L,customerEsperado);
        Mockito.verify(employeService).getById(1L);
    }

    @Test
    void test_update_unsuccess_supportRepId_null() {
        CustomerUpdateDto customerSimulado = new CustomerUpdateDto();
        customerSimulado.setFirstName("unNombre2");


        Customer customerEsperado = new Customer(customerSimulado);


        Mockito.when(customerRepository.update(12L, customerEsperado)).thenReturn(Optional.of(customerEsperado));

        Customer customer = customerServiceImpl.update(12L, customerSimulado).get();
        Assertions.assertEquals(customerEsperado, customer);
        Mockito.verify(customerRepository).update(12L, customerEsperado);
        Mockito.verifyNoInteractions(employeService);
    }
}
