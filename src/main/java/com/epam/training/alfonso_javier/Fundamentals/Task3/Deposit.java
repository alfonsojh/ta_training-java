package com.epam.training.alfonso_javier.Fundamentals.Task3;

import java.math.BigDecimal;

public abstract class Deposit implements Comparable<Deposit> {

    protected BigDecimal amount;
    protected int period;

    protected Deposit(BigDecimal amount, int period) {
        if (amount == null || period <= 0 || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
        this.amount = amount;
        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income();

    public BigDecimal totalAmount() {
        return amount.add(income());
    }

    @Override
    public int compareTo(Deposit o) {
        return this.totalAmount().compareTo(o.totalAmount());
    }
}