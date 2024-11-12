package org.collections.hashing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hashing {
    public static void main(String[] args) {

        String text = "Hello";
        String text2 = "H" + "e" + "l" + "l" + "o";
        String text3 = String.join("l", "He", "lo");
        String text4 = "He".concat("llo");
        String text5 = "hello";

        List<String> list = List.of(text, text2, text3, text4, text5);
        // all the texts will have the same hashcode apart from text5
        list.forEach(s -> System.out.println(s + " -> " + s.hashCode()));

        Set<String> set = new HashSet<>(list);
        System.out.println(set);
        // expected output: [Hello,hello] - > size 2
        System.out.println("size: " + set.size());
        for (String setValue : set) {
            System.out.println(setValue + " -> ");
            for (int i = 0; i < list.size(); i++) {
                if (setValue == list.get(i)) {
                    System.out.println("found at index: " + i);
                }
            }
            System.out.println();
        }

        PlayingCard card1 = new PlayingCard("Hearts", "Ace");
        PlayingCard card2 = new PlayingCard("Clubs", "Kings");
        PlayingCard card3 = new PlayingCard("Spades", "Queen");

        Set<PlayingCard> cardSet = new HashSet<>();
        for (PlayingCard card : List.of(card1, card2, card3)) {
            if (!cardSet.add(card)) {
                System.out.println("Duplicate card: " + card);
            }
        }
        System.out.println(cardSet);
    }
}
