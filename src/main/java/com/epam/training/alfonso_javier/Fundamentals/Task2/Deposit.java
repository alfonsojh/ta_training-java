package com.epam.training.alfonso_javier.Fundamentals.Task2;

import java.math.BigDecimal;

public abstract class Deposit {

    protected final BigDecimal amount;
    protected final int period;

    protected Deposit(BigDecimal amount, int period) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 || period <= 0) {
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
}