package com.lloyds.banking.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    private Long fromAccountNo;
    private Long toAccountNo;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate lastUpdate;
    private Long amount;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
}