package com.example.loan_service.controller;
import com.example.loan_service.model.LoanRequest;
import com.example.loan_service.service.LoanCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanCalculatorService service;

    @PostMapping("/emi")
    public double calculate(@RequestBody LoanRequest request){

        return service.calculateMonthlyInstallment(
                request.getAmount(),
                request.getYears());

    }

}