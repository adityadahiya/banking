package com.lloyds.banking.entities.payment;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lloyds.banking.entities.account.Account;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Long fromAccountNo;
    private Long toAccountNo;
    private LocalDate lastUpdate;
    private Long amount;
    private PaymentType paymentType;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return this.account;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getFromAccountNo() {
        return this.fromAccountNo;
    }

    public void setFromAccountNo(Long fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    public Long getToAccountNo() {
        return this.toAccountNo;
    }

    public void setToAccountNo(Long toAccountNo) {
        this.toAccountNo = toAccountNo;
    }
}