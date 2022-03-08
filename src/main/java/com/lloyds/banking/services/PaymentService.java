package com.lloyds.banking.services;
import com.lloyds.banking.entities.Account;
import com.lloyds.banking.entities.Payment;
import com.lloyds.banking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.time.LocalDate;

@Transactional
@Service
public class PaymentService {
@Autowired
PaymentRepository paymentRepository;
@Autowired
AccountRepository accountRepository;

    public Payment addPayment(Payment payment) {
        Account account = accountRepository.findByAccountNo(payment.getFromAccountNo());
        account.setBalance(account.getBalance() - payment.getAmount());
        accountRepository.save(account);
        
        account = accountRepository.findByAccountNo(payment.getToAccountNo());
        account.setBalance(account.getBalance() + payment.getAmount());
        accountRepository.save(account);

        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment;
    };

    public List<Payment> getLast10Payments() {
        return paymentRepository.findFirst10ByOrderByLastUpdateDesc();
    };

    public List<Payment> getPaymentsByDate(LocalDate fromDate, LocalDate toDate) {
        return paymentRepository.findAllByLastUpdateBetween(fromDate, toDate);
    };
}
