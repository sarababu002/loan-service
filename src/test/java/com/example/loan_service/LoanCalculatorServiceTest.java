package com.example.loan_service;

import com.example.loan_service.service.LoanCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LoanCalculatorServiceTest {

    @Autowired
    LoanCalculatorService service;

    @Test
    void shouldCalculateMonthlyInstallment(){

        double emi = service.calculateMonthlyInstallments(100000,5);

        assertTrue(emi>2000);
    }

    @Test
    void shouldReturnPositiveValue(){

        double emi = service.calculateMonthlyInstallment(500000,10);

        assertTrue(emi>0);

    }

}