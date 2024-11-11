package org.collections;

import java.util.ArrayList;
import java.util.List;

public record Card(Suit suit, String face, int rank) {
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES;

        public char getImage() {
            return switch (this) {
                case HEARTS -> '\u2665';
                case DIAMONDS -> '\u2666';
                case CLUBS -> '\u2663';
                case SPADES -> '\u2660';
            };
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", suit.getImage(), face, rank);
    }

    public static Card getNumericalCard(Suit suit, int cardNumber) {
        if (cardNumber > 1 && cardNumber < 11) {
            return new Card(suit, String.valueOf(cardNumber), cardNumber);
        } else {
            throw new IllegalArgumentException("Card number must be between 2 and 10");

        }
    }

    public static Card getFaceCard(Suit suit, char abbrev) {
        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1) {
            return new Card(suit, String.valueOf(abbrev), charIndex + 9);
        } else {
            throw new IllegalArgumentException("Invalid face card abbreviation");
        }
    }

    public static List<Card> getDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (int i = 2; i < 11; i++) {
                deck.add(getNumericalCard(suit, i));
            }
            for (char face : "JQKA".toCharArray()) {
                deck.add(getFaceCard(suit, face));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("_".repeat(20));
        if (description != null) {
            System.out.println(description);

        }
        int cardsinRow = deck.size() / rows;
        for (int i = 0; i < rows; i++) {
            int startIndex = i * cardsinRow;
            int endIndex = startIndex + cardsinRow;
            deck.subList(startIndex, endIndex).forEach(s -> System.out.print(s + " "));
            System.out.println();

        }
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, "current deck", 4);
    }
}
