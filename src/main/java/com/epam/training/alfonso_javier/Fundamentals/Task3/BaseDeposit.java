package com.epam.training.alfonso_javier.Fundamentals.Task3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {

    public BaseDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {

        BigDecimal result = amount;

        for (int i = 0; i < period; i++) {
            result = result.add(result.multiply(BigDecimal.valueOf(0.05)));
        }

        return result.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }
}