package com.epam.training.alfonso_javier.Fundamentals.Task8;

public class Main {
    public static void main(String[] args) {

        // ofDegrees()
        System.out.println(Direction.ofDegrees(90));     // E
        System.out.println(Direction.ofDegrees(450));    // E
        System.out.println(Direction.ofDegrees(-45));    // NW
        System.out.println(Direction.ofDegrees(100));    // null

        // closestToDegrees()
        System.out.println(Direction.closestToDegrees(100));   // E
        System.out.println(Direction.closestToDegrees(160));   // S
        System.out.println(Direction.closestToDegrees(-20));   // N

        // opposite()
        System.out.println(Direction.N.opposite());      // S
        System.out.println(Direction.SE.opposite());     // NW

        // differenceDegreesTo()
        System.out.println(
                Direction.N.differenceDegreesTo(Direction.W)
        ); // 90

        System.out.println(
                Direction.N.differenceDegreesTo(Direction.S)
        ); // 180

        System.out.println(
                Direction.NE.differenceDegreesTo(Direction.SE)
        ); // 90
    }
}