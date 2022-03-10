package com.lloyds.banking.entities.account;
import java.util.List;

import javax.persistence.*;

import com.lloyds.banking.entities.payment.Payment;

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
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Payment> payments;
    
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
    
    public List<Payment> getPayments() {
        return this.payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
   
}