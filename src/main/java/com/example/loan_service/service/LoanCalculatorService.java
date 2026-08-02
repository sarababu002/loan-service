package com.example.loan_service.service;

import org.springframework.stereotype.Service;

@Service
public class LoanCalculatorService {

    private static final double RATE = 10;

    public double calculateMonthlyInstallment(double amount,int years){

        double monthlyRate = RATE / 100 / 12;

        int months = years * 12;

        return (amount * monthlyRate) /
                (1 - Math.pow(1 + monthlyRate, -months));
    }

}
