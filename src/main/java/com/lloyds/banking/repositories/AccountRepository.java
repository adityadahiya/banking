package com.lloyds.banking.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lloyds.banking.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNo(Long accountNo);
}