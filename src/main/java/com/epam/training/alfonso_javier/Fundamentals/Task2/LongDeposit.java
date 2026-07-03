package com.epam.training.alfonso_javier.Fundamentals.Task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit {

    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal total = amount;

        for (int i = 1; i <= period; i++) {
            if (i > 6) {
                total = total.multiply(new BigDecimal("1.15"))
                        .setScale(5, RoundingMode.HALF_EVEN);
            }
        }

        return total.subtract(amount)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}