package com.k1.Parcial.domain.Service.serviceImpl;

import com.k1.Parcial.domain.repository.InvoiceRepository;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.domain.service.servicesImpl.InvoiceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private InvoiceServiceImpl invoiceServiceImpl;

    @Test
    void getAll() {

    }


}
