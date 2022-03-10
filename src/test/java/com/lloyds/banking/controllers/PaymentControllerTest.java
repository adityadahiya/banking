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
import com.lloyds.banking.entities.account.Account;
import com.lloyds.banking.entities.payment.Payment;
public class PaymentControllerTest {

 
}
