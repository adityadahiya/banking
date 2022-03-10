package com.lloyds.banking.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.lloyds.banking.entities.payment.Payment;

import java.time.LocalDate;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findFirst10ByOrderByLastUpdateDesc();
    List<Payment> findAllByLastUpdateBetween(LocalDate startDate, LocalDate endDate);
    List<Payment> getAllPaymentsByAccount_Id(Long account_id);
}