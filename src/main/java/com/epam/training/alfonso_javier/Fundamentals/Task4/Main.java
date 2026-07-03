package com.epam.training.alfonso_javier.Fundamentals.Task4;

public class Main {

    public static void main(String[] args) {

        Contact contact = new Contact("John Smith");

        contact.addPhoneNumber(44, "444 444-44-44");

        contact.addEmail("john", "gmail.com");
        contact.addEpamEmail("john", "smith");

        contact.addTwitter("@johnsmith");
        contact.addInstagram("@john_insta");
        contact.addSocialMedia("LinkedIn", "john-smith");

        ContactInfo[] info = contact.getInfo();

        for (ContactInfo item : info) {
            System.out.println(item.getTitle() + ": " + item.getValue());
        }

        System.out.println("\n--- Rename Test ---");

        contact.rename("Michael Johnson");

        info = contact.getInfo();

        for (ContactInfo item : info) {
            System.out.println(item.getTitle() + ": " + item.getValue());
        }
    }
}