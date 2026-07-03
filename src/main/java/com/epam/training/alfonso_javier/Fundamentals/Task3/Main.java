package com.epam.training.alfonso_javier.Fundamentals.Task3;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Deposit base = new BaseDeposit(new BigDecimal("1000"), 3);
        Deposit special = new SpecialDeposit(new BigDecimal("1200"), 2);
        Deposit longDep = new LongDeposit(new BigDecimal("1000"), 8);

        System.out.println("Base income: " + base.income());
        System.out.println("Special income: " + special.income());
        System.out.println("Long income: " + longDep.income());

        Client client = new Client();

        client.addDeposit(base);
        client.addDeposit(special);
        client.addDeposit(longDep);

        System.out.println("\nTotal income: " + client.totalIncome());
        System.out.println("Max income: " + client.maxIncome());
        System.out.println("Income #1: " + client.getIncomeByNumber(1));

        System.out.println("\nCan prolong: " + client.countPossibleToProlongDeposit());

        System.out.println("\nSorted:");
        client.sortDeposits();
        for (Deposit d : client) {
            System.out.println(d.getClass().getSimpleName() + " -> " + d.totalAmount());
        }
    }
}