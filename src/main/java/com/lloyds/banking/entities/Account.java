package com.lloyds.banking.entities;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private Long accountNo;
    private String name;
    private Long balance;
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return this.balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
   
}