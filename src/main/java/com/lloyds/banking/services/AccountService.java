package com.lloyds.banking.services;
import com.lloyds.banking.entities.Account;
import com.lloyds.banking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class AccountService {
@Autowired
AccountRepository accountRepository;

    public Account addAccount(Account account) {
        accountRepository.save(account);
        return account;
    };

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    };

    public Account getAccountById(Long id) {
        return accountRepository.getById(id);
    };
}
