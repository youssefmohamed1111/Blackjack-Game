
package blackjack;
import java.lang.Math;
import java.util.*;

import java.util.Random;
public class Game {
    public Player[] players = new Player[4];
    private final int validScore = 21;
    Card[] cardDeck = new Card[52];
    Scanner sc = new Scanner(System.in);
    public void objectify(Player[] players)
    {
        for(int i = 0 ; i < 4 ; i ++)
        {
            players[i] = new Player();
        }
    }




    public void decksetterig(Card[] cardDeck) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (j < 9)
                    cardDeck[i*13 +j] = new Card(i, j, j + 1);
                else cardDeck[i*13 + j] = new Card(i, j, 10);
            }

        }
        //cardDeck[1] = null;
       /* for (int i = 0 ; i< 52 ; i ++)
        {
            System.out.println(cardDeck[i].getValue() + " " + cardDeck[i].getRank() + " " + cardDeck[i].getSuit());
           // System.out.println(cardDeck[i]);
        }*/

    }

    public Card cardDraw(Player players, int id) {
        Random rand = new Random();
        int btenganChoice = rand.nextInt(52);


        while(cardDeck[btenganChoice] == null)
        {

            btenganChoice = rand.nextInt(52);

        }
        Card cardForPlayer = cardDeck[btenganChoice];

        cardDeck[btenganChoice] = null;

        return cardForPlayer;

    }

    public void infoSet( int playerId) {
        //playerId--;
         String name = new String();
        if(playerId == 3)
        {
            name = "Dealer";
        }
       else name= sc.nextLine();


        int score =0;
       // System.out.println(name);

        players[playerId].setName(name);

        players[playerId].cards[0] = cardDraw(players[playerId], playerId);
       score = players[playerId].cards[0].getValue();
        players[playerId].setScore(score);


        players[playerId].cards[1] = cardDraw(players[playerId], playerId);
        score+=players[playerId].cards[1].getValue();
        players[playerId].setScore(score);
        players[playerId].cardNumber = 2;
        System.out.println("Intial Score of Player " + (playerId + 1) + " = " + players[playerId].getScore());


        //players[playerId].
        //maxScore();



    }


    public int maxScore() {
        // Math.max(Math.max(x,y),z);
       /* int max = 0;
        for(int i = 0 ; i < 3 ;i++)
        {
            max =Math.max(max,players[i].getScore());
        }*/
        int x = players[0].getScore() ,y =  players[1].getScore(), z = players[2].getScore();
        if(x > 21)
            x = 0;
        if(y > 21)
            y = 0;
        if(z > 21)
            z = 0;
        int  max = Math.max(Math.max(x,y), z);
        return max;
    }
}






