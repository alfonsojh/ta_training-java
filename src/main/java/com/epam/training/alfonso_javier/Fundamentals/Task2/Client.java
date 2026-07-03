package com.epam.training.alfonso_javier.Fundamentals.Task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Client {

    private final Deposit[] deposits;

    public Client() {
        this.deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal total = BigDecimal.ZERO;

        for (Deposit d : deposits) {
            if (d != null) {
                total = total.add(d.income());
            }
        }

        return total.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal maxIncome() {
        BigDecimal max = BigDecimal.ZERO;

        for (Deposit d : deposits) {
            if (d != null) {
                BigDecimal income = d.income();
                if (income.compareTo(max) > 0) {
                    max = income;
                }
            }
        }

        return max.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getIncomeByNumber(int number) {
        if (number >= 0 && number < deposits.length && deposits[number] != null) {
            return deposits[number].income().setScale(2, RoundingMode.HALF_EVEN);
        }
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
    }
}