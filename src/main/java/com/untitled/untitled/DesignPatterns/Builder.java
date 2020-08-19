package com.untitled.untitled.DesignPatterns;

public interface Builder {

    void reset();
    PaymentBuilder salary(int salary);
    PaymentBuilder tax(int tax);
    PaymentBuilder loan(int loan);
    PaymentBuilder interest(double interest);

}
