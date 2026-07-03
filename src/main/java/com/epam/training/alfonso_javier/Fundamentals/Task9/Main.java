package com.epam.training.alfonso_javier.Fundamentals.Task9;

import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {

        int[] vals1 = new int[]{-2, 0, 10, 5};
        OptionalInt result1 = MaxMethod.max(vals1);

        if (result1.isPresent()) {
            System.out.println("Max: " + result1.getAsInt()); // 10
        } else {
            System.out.println("Empty array");
        }

        int[] vals2 = new int[]{};
        OptionalInt result2 = MaxMethod.max(vals2);
        System.out.println("Is present: " + result2.isPresent()); // false

        int[] vals3 = null;
        OptionalInt result3 = MaxMethod.max(vals3);
        System.out.println("Is present: " + result3.isPresent()); // false
    }
}