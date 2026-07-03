package com.epam.training.alfonso_javier.Fundamentals.Task7;

import java.util.Random;

public class Demo {

    public static void main(String[] args) {
        mulMain();
    }

    static void mulMain() {

        Random r = new Random(10);

        Matrix m1 = randomInit(r, 5, 5);
        Matrix m2 = randomInit(r, 5, 5);

        r = new Random(15);

        Matrix m3 = randomInit(r, 2, 3);
        Matrix m4 = randomInit(r, 3, 2);

        r = new Random(2);

        Matrix m5 = randomInit(r, 3, 1);
        Matrix m6 = randomInit(r, 1, 3);

        System.out.println(m1.multiply(m2));
        System.out.println(m2.multiply(m1));
        System.out.println(m3.multiply(m4));
        System.out.println(m4.multiply(m3));
        System.out.println(m5.multiply(m6));
        System.out.println(m6.multiply(m5));
    }

    static Matrix randomInit(Random r,
                             int rows,
                             int cols) {

        double[][] doubles =
                new double[rows][];

        for (int i = 0; i < rows; i++) {

            doubles[i] =
                    r.doubles(cols, -25., 25.)
                            .toArray();
        }

        return new Matrix(doubles);
    }
}