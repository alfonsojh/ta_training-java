package com.epam.training.alfonso_javier.Fundamentals.Task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit {

    public SpecialDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal total = amount;

        for (int i = 1; i <= period; i++) {
            BigDecimal rate = new BigDecimal(i).divide(new BigDecimal("100"), 10, RoundingMode.HALF_EVEN);
            total = total.add(total.multiply(rate))
                    .setScale(5, RoundingMode.HALF_EVEN);
        }

        return total.subtract(amount)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}