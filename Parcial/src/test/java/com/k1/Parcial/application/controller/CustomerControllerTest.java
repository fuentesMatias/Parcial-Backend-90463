package com.k1.Parcial.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.k1.Parcial.application.request.Customer.CustomerPostDto;
import com.k1.Parcial.domain.service.serviceInterfaces.CustomerService;
import com.k1.Parcial.domain.service.serviceInterfaces.EmployeService;
import com.k1.Parcial.domain.service.serviceInterfaces.InvoiceService;
import com.k1.Parcial.infrastructure.entity.Customer;
import com.k1.Parcial.infrastructure.entity.Employe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;


@WebMvcTest
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private EmployeService employeService;

    @MockBean
    private InvoiceService invoiceService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSave() throws Exception {
        //given
        CustomerPostDto customerPostDto = new CustomerPostDto();
        customerPostDto.setFirstName("Juan");
        customerPostDto.setLastName("Perez");
        customerPostDto.setCompany("unaCompañia");
        customerPostDto.setAddress("unaDireccion");
        customerPostDto.setCity("unaCiudad");
        customerPostDto.setState("unEstado");
        customerPostDto.setCountry("unPais");
        customerPostDto.setPostalCode("unCodigoPostal");
        customerPostDto.setPhone("unTelefono");
        customerPostDto.setFax("unFax");
        customerPostDto.setEmail("unMail@algo.com");
        customerPostDto.setSupportRepId(1L);

        Employe employe = new Employe();
        employe.setId(1L);
        employe.setFirstName("Juan");


        Customer customer = new Customer(customerPostDto,employe);

        given(customerService.save(any(CustomerPostDto.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        //when
        ResultActions response = mockMvc.perform(post("/api/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)));

        //then
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(customerPostDto.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(customerPostDto.getLastName())))
                .andExpect(jsonPath("$.company", is(customerPostDto.getCompany())));

    }
}
