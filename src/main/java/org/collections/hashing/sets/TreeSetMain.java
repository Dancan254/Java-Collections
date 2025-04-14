package org.collections.hashing.sets;

import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> phoneContacts = new TreeSet<>(mySort);
        NavigableSet<Contact> emailContacts = new TreeSet<>(mySort);
        phoneContacts.addAll(phones);
        emailContacts.addAll(emails);

       phoneContacts.forEach(System.out::println);

       emailContacts.forEach(System.out::println);

       NavigableSet<String> justNames = new TreeSet<>();
       phones.forEach(c -> justNames.add(c.getName()));
       justNames.forEach(System.out::println);

       //just messing around with Navigable set
       NavigableSet<Integer> numbers = new TreeSet<>();
       numbers.add(1);
       numbers.add(2);
       numbers.add(3);
       numbers.add(4);
       numbers.add(5);

       //navigation methods
        System.out.println("First number: " + numbers.first());
        System.out.println("Last number: " + numbers.last());
        System.out.println("Higher than 3: " + numbers.higher(3));
        System.out.println("Lower than 3: " + numbers.lower(3));
        System.out.println("Ceiling of 3: " + numbers.ceiling(3));
        System.out.println("Floor of 3: " + numbers.floor(3));
        System.out.println("Poll first: " + numbers.pollFirst());
        System.out.println("Poll last: " + numbers.pollLast());
        System.out.println("Numbers after poll: " + numbers);

        Contact daffy = new Contact("Daffy Duck");
        Contact bugs = new Contact("Bugs Bunny");
        Contact daisy = new Contact("Daisy Duck");
        Contact donald = new Contact("Donald");

        for (Contact c : List.of(daffy, bugs, daisy, donald)) {
            System.out.printf("ceiling of %s: %s%n", c.getName(), phoneContacts.ceiling(c));
            System.out.printf("higher of %s: %s%n", c.getName(), phoneContacts.higher(c));
        }
    }
}
