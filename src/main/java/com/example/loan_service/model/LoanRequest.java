package com.example.loan_service.model;
public class LoanRequest {

    private double amount;
    private int years;

    public LoanRequest() {}

    public LoanRequest(double amount,int years){
        this.amount=amount;
        this.years=years;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}