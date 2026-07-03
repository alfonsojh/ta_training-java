package com.epam.training.alfonso_javier.Fundamentals.Task10;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        NewPostOffice office = new NewPostOffice();

        // Agregar boxes
        office.addBox("Alice", "Bob", 2.0, 0.1, 100);
        office.addBox("John", "Bob", 1.5, 0.05, 50);
        office.addBox("Mary", "Tom", 3.0, 0.2, 200);

        // Ver lista inicial
        System.out.println("All boxes:");
        System.out.println(office.getListBox());

        // Entregar a Bob
        Collection<Box> delivered = office.deliveryBoxToRecipient("Bob");
        System.out.println("\nDelivered to Bob:");
        System.out.println(delivered);

        // Ver lista después de entrega
        System.out.println("\nRemaining boxes:");
        System.out.println(office.getListBox());

        // Reducir costo 10%
        office.declineCostOfBox(10);

        System.out.println("\nAfter 10% discount:");
        System.out.println(office.getListBox());
    }
}