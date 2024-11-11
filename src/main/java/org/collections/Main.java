package org.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEARTS, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray));

        List<Card> cardsList = new ArrayList<>(52);
        Collections.fill(cardsList, aceOfHearts);
        System.out.println(cardsList); // list will be empty since the fill method does not add elements to the list

        List<Card> acesofHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesofHearts, "aces of hearts", 2);// list will have 13 elements of aceOfHearts

        Card kingOfClub = Card.getFaceCard(Card.Suit.CLUBS, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClub);
        Card.printDeck(kingsOfClubs, "kings of clubs", 2);// list will have 13 elements of kingOfClub

        Collections.addAll(cardsList, cardArray); // adds 13 elements of aceOfHearts
        Card.printDeck(cardsList, "cardsList after adding cardArray", 2);

        Collections.copy(cardsList, kingsOfClubs);
        Card.printDeck(cardsList, "cardsList after copying kingsOfClubs", 2);// list will have 13 elements of kingOfClub

        var deck = Card.getDeck();
        Card.printDeck(deck, "Deck of cards", 4);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled deck", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank).thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Sorted deck", 13);

        Collections.reverse(cardsList);
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings", 2);

        boolean disJoint = Collections.disjoint(deck, kings);
        System.out.println("The deck and kings are disjoint: " + disJoint);

        boolean disJoint2 = Collections.disjoint(kings, acesofHearts);
        System.out.println("The kings and aces of hearts are disjoint: " + disJoint2);

        deck.sort(sortingAlgorithm);
        // binary search, elements should be sorted
        Card tensOfHearts = Card.getNumericalCard(Card.Suit.HEARTS, 10);
        int index = Collections.binarySearch(deck, tensOfHearts, sortingAlgorithm);
        System.out.println("Index of 10 of hearts: " + index);
    }
}