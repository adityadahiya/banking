package com.lloyds.banking.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.lloyds.banking.entities.account.Account;
import com.lloyds.banking.repositories.AccountRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AccountServiceTest {
    
    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    AccountRepository accountRepository;

    @Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

    @Test
    public void getAllAccountsTest() {
        List <Account> list = new ArrayList<Account>();
        Account one = new Account();
        one.setId(1L);
        one.setAccountNo(10000L);
        one.setBalance(1000000L);
        one.setName("Aditya");
        Account two = new Account();
        one.setId(2L);
        one.setAccountNo(10001L);
        one.setBalance(1000000L);
        one.setName("Dahiya");
        list.add(one);
        list.add(two);
        when(accountRepository.findAll()).thenReturn(list);

        List <Account> accList = accountService.getAccounts();
        assertEquals(2, accList.size());
    }

    @Test
    public void getAccountByIdTest() {
        Account one = new Account();
        one.setId(1L);
        one.setAccountNo(10000L);
        one.setBalance(1000000L);
        one.setName("Aditya");
        
        when(accountRepository.getById(1L)).thenReturn(one);

        Account res = accountService.getAccountById(1L);
        assertEquals(one.getId(), res.getId());
        assertEquals(one.getAccountNo(), res.getAccountNo());
        assertEquals(one.getName(), res.getName());
        assertEquals(one.getBalance(), res.getBalance());
    }

    @Test
    public void addAccountTest() {
        Account one = new Account();
        one.setId(1L);
        one.setAccountNo(10000L);
        one.setBalance(1000000L);
        one.setName("Aditya");
        
        when(accountRepository.getById(1L)).thenReturn(one);
        Account res = accountService.addAccount(one);
        assertEquals(one.getId(), res.getId());
        assertEquals(one.getAccountNo(), res.getAccountNo());
        assertEquals(one.getName(), res.getName());
        assertEquals(one.getBalance(), res.getBalance());
    }
}
