package com.lloyds.banking.payment;
import com.lloyds.banking.entities.Payment;
import com.lloyds.banking.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/pay")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping
    public List<Payment> getLast10Payments() {
        return paymentService.getLast10Payments();
    }
    @GetMapping("/custom")
    public List<Payment> getPaymentsByDate(@RequestParam("fromDate") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fromDate, @RequestParam("toDate") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate toDate) {
        return paymentService.getPaymentsByDate(fromDate, toDate);
    }

    @PostMapping
    public Payment post(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }
}