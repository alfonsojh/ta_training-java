package com.epam.training.alfonso_javier.Fundamentals.Task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {

    public BaseDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal total = amount;

        for (int i = 0; i < period; i++) {
            total = total.multiply(new BigDecimal("1.05"))
                    .setScale(5, RoundingMode.HALF_EVEN);
        }

        return total.subtract(amount)
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}