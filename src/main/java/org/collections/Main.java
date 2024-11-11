package org.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        // this works on the various collections
        Collection<String> nameList = new ArrayList<>();
        String[] names = { "Alice", "Bob", "Charlie", "David" };
        nameList.addAll(Arrays.asList(names));
        nameList.addAll(Arrays.asList("Eve", "Frank", "Grace", "Helen"));

        System.out.println("Grace is in the list: " + nameList.contains("Grace"));
        nameList.forEach(System.out::println);
        nameList.removeIf(s -> s.startsWith("H"));

        nameList.forEach(System.out::println);
        // nameList.sort(); -> wont work as it is abstracted in the List interface

        // for the Card game
        var deck = Card.getDeck();
        Card.printDeck(deck);

        Card[] cards = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEARTS, 'A');
        Arrays.fill(cards, aceOfHearts);
        Card.printDeck(Arrays.asList(cards));
    }
}