package com.lloyds.banking.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lloyds.banking.entities.Payment;
import java.util.List;
import java.time.LocalDate;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findFirst10ByOrderByLastUpdateDesc();
    List<Payment> findAllByLastUpdateBetween(LocalDate startDate, LocalDate endDate);
}