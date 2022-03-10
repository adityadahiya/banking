package com.lloyds.banking.controllers;
import com.lloyds.banking.entities.account.Account;
import com.lloyds.banking.exceptions.CustomException;
import com.lloyds.banking.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> get() throws CustomException {
        try{
            return accountService.getAccounts();
        }
        catch(Exception exception){
            System.out.println(exception);
            throw new CustomException("Error connecting to server. Please try again");
        }  
    }
    
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) throws CustomException {
        try{
            return accountService.getAccountById(id);
        }
        catch(Exception exception){
            System.out.println(exception);
            throw new CustomException("Error connecting to server. Please try again");
        }  
    }

    @PostMapping
    public Account post(@RequestBody Account account) throws CustomException {
        try{
            return accountService.addAccount(account);
        }
        catch(Exception exception){
            System.out.println(exception);
            throw new CustomException("Error connecting to server. Please try again");
        }  
    }

}