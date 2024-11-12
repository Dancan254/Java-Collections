package org.collections.hashing;

public class PlayingCard {
    String face;
    String suit;
    int internalHash;

    public PlayingCard(String face, String suit) {
        this.face = face;
        this.suit = suit;
        this.internalHash = 1;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", suit, face);
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        System.out.println("Suit hash: " + result);
        result = 31 * result + face.hashCode();
        System.out.println("Face hash: " + result);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(this + " vs " + obj);
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PlayingCard card = (PlayingCard) obj;
        System.out.println("Checking card equality: " + this + " vs " + card);
        return face.equals(card.face) && suit.equals(card.suit);
    }

    /*
     * @Override
     * public int hashCode() {
     * return internalHash;
     * }
     * 
     * @Override
     * public boolean equals(Object obj) {
     * System.out.println("Checking card equality: " + this + " vs " + obj);
     * return true;
     * }
     */
}
