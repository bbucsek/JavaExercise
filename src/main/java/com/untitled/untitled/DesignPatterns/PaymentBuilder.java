package com.untitled.untitled.DesignPatterns;

public class PaymentBuilder implements Builder {

    private Payment payment;

    public PaymentBuilder() {
        reset();
    }

    public Payment build() {
        Payment pay = this.payment;
        reset();
        return pay;
    }

    @Override
    public void reset() {
        this.payment = new Payment();
    }

    @Override
    public PaymentBuilder salary(int salary) {
        payment.setSalary(salary);
        return this;
    }

    @Override
    public PaymentBuilder tax(int tax) {
        payment.setTax(tax);
        return this;
    }

    @Override
    public PaymentBuilder loan(int loan) {
        payment.setLoan(loan);
        return this;
    }

    @Override
    public PaymentBuilder interest(double interest) {
        payment.setInterest(interest);
        return this;
    }


}
