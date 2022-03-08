package com.lloyds.banking.account;
import com.lloyds.banking.entities.Account;
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
    public List<Account> get() {
        return accountService.getAccounts();
    }
    
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public Account post(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

}