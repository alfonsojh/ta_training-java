package com.epam.training.alfonso_javier.Fundamentals.Task10;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {

    private final Collection<Box> listBox;

    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return new ArrayList<>(listBox);
    }

    static BigDecimal calculateCostOfBox(double weight, double volume, int value) {

        BigDecimal costWeight = new BigDecimal(String.valueOf(weight))
                .multiply(BigDecimal.valueOf(COST_KILOGRAM));

        BigDecimal costVolume = new BigDecimal(String.valueOf(volume))
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER));

        BigDecimal costValue = new BigDecimal(String.valueOf(value))
                .multiply(BigDecimal.valueOf(COEFFICIENT));

        return costWeight.add(costVolume).add(costValue);
    }

    public boolean addBox(String addresser, String recipient,
                          double weight, double volume, int value) {

        if (addresser == null
                || recipient == null
                || weight < 0.5 || weight > 20.0
                || volume <= 0 || volume > 0.25
                || value <= 0) {
            throw new IllegalArgumentException();
        }

        Box box = new Box(addresser, recipient, weight, volume);
        box.setCost(calculateCostOfBox(weight, volume, value));

        return listBox.add(box);
    }

    public Collection<Box> deliveryBoxToRecipient(String recipient) {

        Collection<Box> result = new ArrayList<>();
        Iterator<Box> it = listBox.iterator();

        while (it.hasNext()) {
            Box box = it.next();

            if (box.getRecipient().equals(recipient)) {
                result.add(box);
                it.remove();
            }
        }

        return result;
    }

    public void declineCostOfBox(double percent) {

        Iterator<Box> it = listBox.iterator();

        BigDecimal percentBD = BigDecimal.valueOf(percent)
                .divide(BigDecimal.valueOf(100));

        while (it.hasNext()) {
            Box box = it.next();

            BigDecimal current = box.getCost();
            BigDecimal discount = current.multiply(percentBD);

            box.setCost(current.subtract(discount));
        }
    }
}