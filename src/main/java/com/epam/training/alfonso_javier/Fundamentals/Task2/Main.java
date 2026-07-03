package com.epam.training.alfonso_javier.Fundamentals.Task2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Deposit d1 = new BaseDeposit(new BigDecimal("1000"), 3);
        Deposit d2 = new SpecialDeposit(new BigDecimal("1000"), 2);
        Deposit d3 = new LongDeposit(new BigDecimal("1000"), 8);

        System.out.println("BaseDeposit: " + d1.income());
        System.out.println("SpecialDeposit: " + d2.income());
        System.out.println("LongDeposit: " + d3.income());

        Client client = new Client();
        client.addDeposit(d1);
        client.addDeposit(d2);
        client.addDeposit(d3);

        System.out.println("Total income: " + client.totalIncome());
        System.out.println("Max income: " + client.maxIncome());
        System.out.println("Income index 1: " + client.getIncomeByNumber(1));
    }
}