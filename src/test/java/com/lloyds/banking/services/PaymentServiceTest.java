package com.lloyds.banking.services;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lloyds.banking.entities.payment.Payment;
import com.lloyds.banking.entities.payment.PaymentType;
import com.lloyds.banking.repositories.AccountRepository;
import com.lloyds.banking.repositories.PaymentRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PaymentServiceTest {

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    @Mock
    AccountRepository accountRepository;

    @Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

    @Test
    public void getPaymentsByAccountID () {
        List <Payment> list = new ArrayList<Payment>();
        Payment one = new Payment();
        one.setId(1L);
        one.setAmount(10000L);
        one.setFromAccountNo(1000000L);
        one.setToAccountNo(1000000L);
        one.setPaymentType(PaymentType.CREDIT);

        Payment two = new Payment();
        two.setId(1L);
        two.setAmount(10000L);
        two.setFromAccountNo(1000000L);
        two.setToAccountNo(1000000L);
        two.setPaymentType(PaymentType.DEBIT);

        list.add(one);
        list.add(two);
        
        when(paymentRepository.getAllPaymentsByAccount_Id(1000000L)).thenReturn(list);

        List <Payment> resultList = paymentService.getPaymentsByAccountID(1000000L);
        assertEquals(2, resultList.size());
    }
}
