package org.collections.hashing.sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {
    // contains name, phone number
    private static final String phoneData = """
            Ian Dancan, 1234567890
            John Doe, 0987654321
            Jane Smith, 5551234567
            Alice Johnson, 4445556666
            Bob Brown, 7778889999
            """;

    private static final String emailData = """
            Ian Dancan, ian.dancan@example.com
            John Doe, john.doe@example.com
            Jane Smith, jane.smith@example.com
            Alice Johnson, alice.johnson@example.com
            Bob Brown, bob.brown@example.com
            """;

    public static List<Contact> getData(String type) {

        List<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("phone") ? phoneData : emailData);
        while (scanner.hasNext()) {
            String[] contactData = scanner.nextLine().split(", ");
            Arrays.asList(contactData).replaceAll(String::trim);
            if (type.equals("phone")) {
                contacts.add(new Contact(contactData[0], Long.parseLong(contactData[1])));
            } else {
                contacts.add(new Contact(contactData[0], contactData[1]));
            }
        }
        return contacts;
    }
}
