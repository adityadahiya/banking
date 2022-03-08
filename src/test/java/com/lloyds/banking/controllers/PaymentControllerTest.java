package com.lloyds.banking.controllers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.lloyds.banking.repositories.*;
import com.lloyds.banking.services.PaymentService;
import com.lloyds.banking.TestUtils;
import com.lloyds.banking.entities.Account;
import com.lloyds.banking.entities.Payment;
import com.lloyds.banking.payment.*;
public class PaymentControllerTest {

 
    private PaymentRepository paymentRepository = mock(PaymentRepository.class);
    private AccountRepository accountRepository = mock(AccountRepository.class);
    private PaymentService paymentService = mock(PaymentService.class);

    @Before
    public void setUp() {

        Account accountFrom = new Account();
        accountFrom.setAccountNo(10000L);
        accountFrom.setBalance(100000L);
        accountFrom.setName("Aditya");
        accountFrom.setId(1L);

        Account accountTo = new Account();
        accountTo.setAccountNo(10001L);
        accountTo.setBalance(100000L);
        accountTo.setName("Dahiya");
        accountTo.setId(2L);

        Payment payment = new Payment();
        payment.setId(1L);
        payment.setAmount(10000L);
        payment.setFromAccountNo(10000L);
        payment.setToAccountNo(10001L);
        payment.setLastUpdate(LocalDate.parse("01-03-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        when(accountRepository.findByAccountNo(10000L)).thenReturn(accountFrom);
        when(accountRepository.findByAccountNo(10001L)).thenReturn(accountTo);
        when(paymentService.addPayment(new Payment())).thenReturn(payment);
    }
    @Test
    public void addPayment() {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setAmount(10000L);
        payment.setFromAccountNo(10000L);
        payment.setToAccountNo(10001L);
        payment.setLastUpdate(LocalDate.parse("01-03-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        Payment savedPayment = paymentService.addPayment(payment);
        
        Account accountFrom = accountRepository.findByAccountNo(10000L);
        Account accountTo = accountRepository.findByAccountNo(10001L);
        assertNotNull(savedPayment);
        assertEquals(savedPayment.getFromAccountNo(), accountFrom.getAccountNo());
        assertEquals(savedPayment.getToAccountNo(), accountTo.getAccountNo());

    }
}
