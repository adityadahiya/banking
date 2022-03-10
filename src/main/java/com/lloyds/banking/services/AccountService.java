package com.lloyds.banking.services;
import com.lloyds.banking.entities.account.Account;
import java.util.List;

public interface AccountService {

    public Account addAccount(Account account);
    public List<Account> getAccounts();
    public Account getAccountById(Long id);
}
