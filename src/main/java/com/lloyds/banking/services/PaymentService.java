package com.lloyds.banking.services;
import com.lloyds.banking.entities.payment.Payment;
import com.lloyds.banking.entities.payment.PaymentDTO;
import java.util.List;
import java.time.LocalDate;

public interface PaymentService {

    public Payment addPayment(PaymentDTO paymentDTO);
    public List<Payment> getLast10Payments();
    public List<Payment> getPaymentsByDate(Long accountID, LocalDate fromDate, LocalDate toDate);
    public List<Payment> getPaymentsByAccountID(Long accountID);
}
