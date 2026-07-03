package com.epam.training.alfonso_javier.Fundamentals.Task3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit implements Prolongable {

    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {

        BigDecimal result = amount;

        for (int i = 1; i <= period; i++) {

            if (i > 6) {
                result = result.add(result.multiply(BigDecimal.valueOf(0.15)));
            }
        }

        return result.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean canToProlong() {
        return period >= 36;
    }
}