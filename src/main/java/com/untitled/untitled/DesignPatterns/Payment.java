package com.untitled.untitled.DesignPatterns;

public class Payment {

    private int salary;
    private int tax;
    private int loan;
    private double interest;

    public Payment() {}

    public Payment(int salary, int tax, int loan, double interest) {
        this.salary = salary;
        this.tax = tax;
        this.loan = loan;
        this.interest = interest;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
