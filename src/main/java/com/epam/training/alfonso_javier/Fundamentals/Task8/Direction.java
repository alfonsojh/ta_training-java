package com.epam.training.alfonso_javier.Fundamentals.Task8;

public enum Direction {
    N(0), NE(45), E(90), SE(135),
    S(180), SW(225), W(270), NW(315);

    private final int degrees;

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    // Normaliza a rango [0,360)
    private static int normalize(int degrees) {
        return ((degrees % 360) + 360) % 360;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = normalize(degrees);

        for (Direction d : values()) {
            if (d.degrees == degrees) {
                return d;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = normalize(degrees);

        Direction closest = null;
        int minDiff = Integer.MAX_VALUE;

        for (Direction d : values()) {
            int diff = Math.abs(degrees - d.degrees);

            // Maneja el círculo (ej. 350° está más cerca de 0° que de 315°)
            diff = Math.min(diff, 360 - diff);

            if (diff < minDiff) {
                minDiff = diff;
                closest = d;
            }
        }

        return closest;
    }

    public Direction opposite() {
        return closestToDegrees(this.degrees + 180);
    }

    public int differenceDegreesTo(Direction direction) {
        int diff = Math.abs(this.degrees - direction.degrees);

        return Math.min(diff, 360 - diff);
    }
}