package blackjack;

import java.util.*;

public class Player {
     private int score;
    private String name = new  String();

    public boolean isBusted() {
        return busted;
    }

    public void setBusted(boolean busted) {
        this.busted = busted;
    }

    public Card[] cards = new Card[11];
    public int cardNumber = 0;
   private boolean blackjacked = false;
    private boolean busted = false;

    public boolean isBlackjacked() {
        return blackjacked;
    }

    public void setBlackjacked(boolean blackjacked) {
        this.blackjacked = blackjacked;
    }
/*public Player(int score, String name, Card[] cards) {
        this.score = score;
        this.name = name;
        this.cards = cards;
    }*/

    public String getName() {
        return name;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }







}
