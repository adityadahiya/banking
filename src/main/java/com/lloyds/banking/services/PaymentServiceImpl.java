package com.lloyds.banking.services;
import com.lloyds.banking.entities.account.Account;
import com.lloyds.banking.entities.payment.Payment;
import com.lloyds.banking.entities.payment.PaymentDTO;
import com.lloyds.banking.entities.payment.PaymentType;
import com.lloyds.banking.repositories.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.time.LocalDate;

@Transactional
@Service
public class PaymentServiceImpl implements PaymentService{
@Autowired
PaymentRepository paymentRepository;
@Autowired
AccountRepository accountRepository;

    public Payment addPayment(PaymentDTO paymentDTO) {
        //For Debit
        Account account = accountRepository.findByAccountNo(paymentDTO.getFromAccountNo());
        account.setBalance(account.getBalance() - paymentDTO.getAmount());
        accountRepository.save(account);
        Payment paymentDB = saveDebitAndCreditPayments(paymentDTO, account, PaymentType.DEBIT);        
        
        //For Credit
        account = accountRepository.findByAccountNo(paymentDTO.getToAccountNo());
        account.setBalance(account.getBalance() + paymentDTO.getAmount());
        accountRepository.save(account);
        saveDebitAndCreditPayments(paymentDTO, account, PaymentType.CREDIT);
        return paymentDB;
    };

    private Payment saveDebitAndCreditPayments(PaymentDTO paymentDTO, Account account, PaymentType paymentType) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDTO, payment);
        payment.setPaymentType(paymentType);
        payment.setAccount(account);
        return paymentRepository.save(payment);
    }

    public List<Payment> getLast10Payments(Long accountID) {
        return paymentRepository.findFirst10ByOrderByLastUpdateDesc();
    };

    public List<Payment> getPaymentsByDate(Long accountID, LocalDate fromDate, LocalDate toDate) {
        return paymentRepository.findAllByLastUpdateBetween(fromDate, toDate);
    };

    public List<Payment> getPaymentsByAccountID(Long accountID) {
        return paymentRepository.getAllPaymentsByAccount_Id(accountID);
    };
}