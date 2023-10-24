package com.k1.Parcial.domain.Service.serviceImpl;

import com.k1.Parcial.application.request.Invoice.InvoicePostDto;
import com.k1.Parcial.application.request.Invoice.InvoiceUpdateDto;
import com.k1.Parcial.application.request.InvoiceItem.InvoiceItemRequestDto;
import com.k1.Parcial.domain.repository.InvoiceRepository;
import com.k1.Parcial.domain.service.ServiceException;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.domain.service.servicesImpl.InvoiceServiceImpl;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Invoice;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private InvoiceServiceImpl invoiceServiceImpl;

    @Test
    void test_getAll() {
        Invoice invoiceSimulado = new Invoice();
        invoiceSimulado.setId(1L);
        invoiceSimulado.setTotal(1000.0);

        Mockito.when(invoiceRepository.getAll()).thenReturn(List.of(invoiceSimulado));
        Invoice invoicesRespuesta = invoiceServiceImpl.getAll().iterator().next();

        Assertions.assertEquals(invoiceSimulado, invoicesRespuesta);
        Mockito.verify(invoiceRepository).getAll();
    }

    @Test
    void test_getById_success() {
        Invoice invoiceSimulado = new Invoice();
        invoiceSimulado.setId(1L);
        invoiceSimulado.setTotal(1000.0);

        Mockito.when(invoiceRepository.getById(1L)).thenReturn(java.util.Optional.of(invoiceSimulado));
        Invoice invoiceRespuesta = invoiceServiceImpl.getById(1L).get();

        Assertions.assertEquals(invoiceSimulado, invoiceRespuesta);
        Mockito.verify(invoiceRepository).getById(1L);
    }

    @Test
    void test_getById_unsuccess_bad_id() {
        Invoice invoiceSimulado = new Invoice();
        invoiceSimulado.setId(1L);
        invoiceSimulado.setTotal(1000.0);

        Invoice invoiceSimulado2 = new Invoice();
        invoiceSimulado2.setId(2L);
        invoiceSimulado2.setTotal(2000.0);

        Mockito.when(invoiceRepository.getById(2L)).thenReturn(java.util.Optional.of(invoiceSimulado2));
        Invoice invoiceRespuesta = invoiceServiceImpl.getById(2L).get();

        Assertions.assertNotEquals(invoiceSimulado, invoiceRespuesta);
        Mockito.verify(invoiceRepository).getById(2L);
    }

    @Test
    void test_getById_id_negative() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            invoiceServiceImpl.getById(-1L);
        });
    }

    @Test
    void test_getById_unsuccess_not_found() {
        Invoice invoiceSimulado = new Invoice();
        invoiceSimulado.setId(1L);
        invoiceSimulado.setTotal(1000.0);

        Invoice invoiceSimulado2 = new Invoice();
        invoiceSimulado2.setId(2L);
        invoiceSimulado2.setTotal(2000.0);

        Mockito.when(invoiceRepository.getById(2L)).thenReturn(java.util.Optional.of(invoiceSimulado2));
        Invoice invoiceRespuesta = invoiceServiceImpl.getById(2L).get();

        Assertions.assertNotEquals(invoiceSimulado, invoiceRespuesta);
        Mockito.verify(invoiceRepository).getById(2L);
    }

    @Test
    void test_getById_throw(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            invoiceServiceImpl.getById(null);
        });
    }

    @Test
    void test_save_success() {
        InvoicePostDto invoiceSimulado = new InvoicePostDto();
        invoiceSimulado.setTotal(1000.0);
        invoiceSimulado.setCustomerId(1L);
        invoiceSimulado.setBillingState("unBillingState");

        Customer customerSimulado = new Customer();
        customerSimulado.setId(1L);
        customerSimulado.setFirstName("unNombre2");

        Invoice invoice = new Invoice(invoiceSimulado,customerSimulado);

        Mockito.when(customerService.getById(1L)).thenReturn(java.util.Optional.of(customerSimulado));
        Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice);
        Invoice invoiceRespuesta = invoiceServiceImpl.save(invoiceSimulado);

        Assertions.assertEquals(invoice, invoiceRespuesta);
        Mockito.verify(invoiceRepository).save(invoice);
    }

    @Test
    void test_save_unsuccess_diff()  {
        InvoicePostDto invoiceSimulado = new InvoicePostDto();
        invoiceSimulado.setTotal(1000.0);
        invoiceSimulado.setCustomerId(1L);
        invoiceSimulado.setBillingState("unBillingState");

        Customer customerSimulado = new Customer();
        customerSimulado.setId(1L);
        customerSimulado.setFirstName("unNombre2");

        Invoice invoice = new Invoice(invoiceSimulado,customerSimulado);

        Invoice invoice2 = new Invoice();
        invoice2.setId(2L);
        invoice2.setTotal(2000.0);


        Mockito.when(customerService.getById(1L)).thenReturn(java.util.Optional.of(customerSimulado));
        Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice2);
        Invoice invoiceRespuesta = invoiceServiceImpl.save(invoiceSimulado);

        Assertions.assertNotEquals(invoice, invoiceRespuesta);
        Mockito.verify(invoiceRepository).save(invoice);
    }

    @Test
    void  test_save_throw(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            invoiceServiceImpl.save(null);
        });
    }

    @Test
    void test_update_success() {
        InvoiceUpdateDto invoiceSimulado = new InvoiceUpdateDto();
        invoiceSimulado.setTotal(1000.0);
        invoiceSimulado.setCustomerId(1L);
        invoiceSimulado.setBillingState("unBillingState");

        Customer customerSimulado = new Customer();
        customerSimulado.setId(1L);
        customerSimulado.setFirstName("unNombre2");

        Invoice invoice = new Invoice(invoiceSimulado,customerSimulado);

        Mockito.when(customerService.getById(1L)).thenReturn(Optional.of(customerSimulado));
        Mockito.when(invoiceRepository.update(1L,invoice)).thenReturn(Optional.of(invoice));
        Invoice invoiceRespuesta = invoiceServiceImpl.update(1L,invoiceSimulado).get();
        Assertions.assertEquals(invoice, invoiceRespuesta);
        Mockito.verify(invoiceRepository).update(1L,invoice);
    }

    @Test
    void test_update_unsuccess_diff() {
        InvoiceUpdateDto invoiceSimulado = new InvoiceUpdateDto();
        invoiceSimulado.setTotal(1000.0);
        invoiceSimulado.setCustomerId(1L);
        invoiceSimulado.setBillingState("unBillingState");

        Customer customerSimulado = new Customer();
        customerSimulado.setId(1L);
        customerSimulado.setFirstName("unNombre2");

        Invoice invoice = new Invoice(invoiceSimulado, customerSimulado);

        Invoice invoiceOtro = new Invoice();

        Mockito.when(customerService.getById(1L)).thenReturn(Optional.of(customerSimulado));
        Mockito.when(invoiceRepository.update(1L, invoice)).thenReturn(Optional.of(invoiceOtro));
        Invoice invoiceRespuesta = invoiceServiceImpl.update(1L, invoiceSimulado).get();
        Assertions.assertNotEquals(invoice, invoiceRespuesta);
        Mockito.verify(invoiceRepository).update(1L, invoice);
    }

    @Test
    void test_update_throw(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            invoiceServiceImpl.update(null,null);
        });
    }

}
