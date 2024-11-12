package org.collections.hashing.sets;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null) {
            emails.add(email);
        }
        if (phone > 0) {
            String phoneStr = String.valueOf(phone);
            // format the phone number
            phoneStr = phoneStr.substring(0, 3) + "-" + phoneStr.substring(3, 6) + "-" + phoneStr.substring(6);
            phones.add(phoneStr);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + emails + " " + phones;
    }

    public Contact mergeContactData(Contact other) {
        Contact newContact = new Contact(name);
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(other.emails);
        newContact.phones.addAll(other.phones);
        return newContact;
    }
}
