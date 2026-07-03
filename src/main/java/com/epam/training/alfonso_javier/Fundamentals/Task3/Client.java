package com.epam.training.alfonso_javier.Fundamentals.Task3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Client implements Iterable<Deposit> {

    private Deposit[] deposits;

    public Client() {
        this.deposits = new Deposit[10];
    }

    public Client(Deposit[] deposits) {
        if (deposits == null) {
            throw new IllegalArgumentException();
        }
        this.deposits = deposits;
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

    public double totalIncome() {
        double sum = 0;
        for (Deposit d : deposits) {
            if (d != null) {
                sum += d.income().doubleValue();
            }
        }
        return sum;
    }

    public double maxIncome() {
        double max = 0;
        for (Deposit d : deposits) {
            if (d != null) {
                max = Math.max(max, d.income().doubleValue());
            }
        }
        return max;
    }

    public double getIncomeByNumber(int number) {
        if (number < 0 || number >= deposits.length || deposits[number] == null) {
            return 0;
        }
        return deposits[number].income().doubleValue();
    }

    public void sortDeposits() {
        Arrays.sort(deposits, (a, b) -> {
            if (a == null && b == null) return 0;
            if (a == null) return 1;
            if (b == null) return -1;
            return b.compareTo(a);
        });
    }

    public int countPossibleToProlongDeposit() {
        int count = 0;

        for (Deposit d : deposits) {
            if (d instanceof Prolongable) {
                if (((Prolongable) d).canToProlong()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Iterator<Deposit> iterator() {
        return new Iterator<>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                while (index < deposits.length && deposits[index] == null) {
                    index++;
                }
                return index < deposits.length;
            }

            @Override
            public Deposit next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return deposits[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}