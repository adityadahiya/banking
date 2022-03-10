package com.lloyds.banking.repositories;
import com.lloyds.banking.entities.account.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNo(Long accountNo);
}