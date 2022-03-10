package com.lloyds.banking.controllers;
import com.lloyds.banking.entities.payment.Payment;
import com.lloyds.banking.entities.payment.PaymentDTO;
import com.lloyds.banking.exceptions.CustomException;
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
    public List<Payment> getLast10Payments(@PathVariable Long accountID) throws CustomException {
        try{
            return paymentService.getLast10Payments(accountID);
        }
        catch(Exception exception){
            System.out.println(exception);
            throw new CustomException("Error connecting to server. Please try again");
        }
        
    }

    @GetMapping("/{accountId}")
    public List<Payment> getPaymentsByAccountID(@PathVariable Long accountID) throws CustomException {
        try{
            return paymentService.getPaymentsByAccountID(accountID);
        }
        catch(Exception exception){
            System.out.println(exception);
            throw new CustomException("Error connecting to server. Please try again");
        }
    }

    @GetMapping("/custom")
    public List<Payment> getPaymentsByDate(@RequestParam("accountID") Long accountID, @RequestParam("fromDate") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fromDate, @RequestParam("toDate") @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate toDate) throws CustomException {
        try{
            return paymentService.getPaymentsByDate(accountID, fromDate, toDate);
        }
        catch(Exception exception){
            System.out.println(exception);
            throw new CustomException("Error connecting to server. Please try again");
        }
    }

    @PostMapping
    public Payment post(@RequestBody PaymentDTO paymentDTO) throws CustomException {
        try{
            return paymentService.addPayment(paymentDTO);
        }
        catch(Exception exception){
            System.out.println(exception);
            throw new CustomException("Error connecting to server. Please try again");
        }        
    }
}