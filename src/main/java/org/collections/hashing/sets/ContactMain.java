package org.collections.hashing.sets;

import java.util.Collection;

public class ContactMain {
    public static void main(String[] args) {

        Collection<Contact> phoneContacts = ContactData.getData("phone");
        Collection<Contact> emailContacts = ContactData.getData("email");

        printData("Phone Contacts", phoneContacts);
        printData("Email Contacts", emailContacts);
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("_".repeat(30));
        System.out.println(header);
        contacts.forEach(System.out::println);
    }
}
