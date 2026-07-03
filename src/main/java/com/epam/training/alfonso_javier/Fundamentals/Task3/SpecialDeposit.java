package com.epam.training.alfonso_javier.Fundamentals.Task3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable {

    public SpecialDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal result = amount;

        for (int i = 1; i <= period; i++) {
            BigDecimal percent = BigDecimal.valueOf(i)
                    .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);

            result = result.add(amount.multiply(percent));
        }

        return result.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean canToProlong() {
        return amount.compareTo(BigDecimal.valueOf(1000)) > 0;
    }
}