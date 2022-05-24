package blackjack;
import java.sql.SQLOutput;
import java.util.*;


public class BlackJack {

   public static void main(String[] args) {
       GUI gui = new GUI();
       Card[] Deck = new Card[52];
       //Player players = new Player();
       Game game = new Game();
       game.decksetterig(game.cardDeck);
       ;
       //String state = new String();
       game.objectify(game.players);
       Scanner sc = new Scanner(System.in);
       int x = 3;



       System.out.println("Player 1's Name : ");
       game.infoSet(0);
       System.out.println("Player 2's Name : ");
       game.infoSet(1);
       System.out.println("Player 3's Name : ");
       game.infoSet(2);
       int mx = 0;
       game.infoSet(3);
       game.maxScore();
       //System.out.println(game.maxScore());
       gui.runGUI(game.cardDeck, game.players[0].cards, game.players[1].cards, game.players[2].cards, game.players[3].cards);
       /*if(game.players[3].getScore() > game.maxScore() ) {
           System.out.println("Dealer Has Won!");
           System.exit(0);
       }*/
       System.out.println(game.players[0].getName() + "'s Turn!");
       boolean isStanding = false;int score = game.players[0].getScore();
       while (x > 0 && !isStanding) {
           System.out.print("H or S : ");
           char c = sc.next().charAt(0);

           if (c == 'H') {

               game.players[0].cards[game.players[0].cardNumber] = game.cardDraw(game.players[0], 0);
               gui.updatePlayerHand(game.players[0].cards[game.players[0].cardNumber], 0);

               score += game.players[0].cards[game.players[0].cardNumber].getValue();
               game.players[2].setScore(score);
               game.maxScore();
               //System.out.println(game.maxScore());

               game.players[0].cardNumber++;



           }
           if (score == 21) {
               System.out.println(game.players[0].getName() + " Has Won!");
               game.players[0].setBlackjacked(true);
               mx ++;
               break;
               //System.exit(0);
           }
           if (score > 21) {
               System.out.println(game.players[0].getName() + " Got BUSTED!");
               game.players[0].setBusted(true);
               break;

           } else if (c == 'S') {
               isStanding = true;
           }
           x--;
       }
       //Second Player
       x = 3;

       isStanding = false;
       //boolean busted1 = false ,busted2 = false ,busted3 = false,busted4 = false;
       System.out.println(game.players[1].getName() + "'s Turn!");

        score = game.players[1].getScore();
       while (x > 0 && !isStanding) {
           System.out.print("H or S : ");
           char c = sc.next().charAt(0);

           if (c == 'H') {
               game.players[1].cards[game.players[1].cardNumber] = game.cardDraw(game.players[1], 1);
               gui.updatePlayerHand(game.players[1].cards[game.players[1].cardNumber], 1);

               score += game.players[1].cards[game.players[1].cardNumber].getValue();
               game.players[1].setScore(score);
               game.players[1].cardNumber++;
               //System.out.println("Score Of the Btengana2 = " + game.players[1].getScore());
               game.maxScore();
               //System.out.println(game.maxScore());


           }
           if (score == 21) {
               System.out.println(game.players[1].getName() + " Has Won!");
               game.players[1].setBlackjacked(true);
               mx ++; break;
              // System.exit(0);
           }
           if (score > 21) {
               System.out.println(game.players[1].getName() + " Got BUSTED!");
               game.players[1].setBusted(true);
               break;

           } else if (c == 'S') {
               isStanding = true;
           }
           x--;
       }
       // 3rd Player

       //PlayerName = sc.nextLine();


       x = 3;
       System.out.println(game.players[2].getName() + "'s Turn!");
       isStanding = false; score = game.players[2].getScore();
       while (x > 0 && !isStanding) {
           System.out.print("H or S : ");
           char c = sc.next().charAt(0);

           if (c == 'H') {

               game.players[2].cards[game.players[2].cardNumber] = game.cardDraw(game.players[2], 2);
               gui.updatePlayerHand(game.players[2].cards[game.players[2].cardNumber], 2);
               score += game.players[2].cards[game.players[2].cardNumber].getValue();
               game.players[2].setScore(score);
               game.players[2].cardNumber++;
               game.maxScore();
             //  System.out.println(game.maxScore());



           }
           if (score == 21) {
               System.out.println(game.players[2].getName() + " Has Won!");
               //System.exit(0);
               game.players[2].setBlackjacked(true);
               mx ++;
               break;

           }
           if (score > 21) {

               System.out.println(game.players[2].getName() + " Got BUSTED!");
               game.players[2].setBusted(true);
               break;

           } else if (c == 'S') {
               isStanding = true;
           }
           x--;
       }
       boolean blackjacked = false;


       System.out.println(game.players[3].getName() + "'s Turn!"); score = game.players[3].getScore();
       if(game.players[0].isBusted() && game.players[1].isBusted()&& game.players[2].isBusted() ||game.players[3].getScore() > game.maxScore() ) {
           System.out.println("Dealer Has Won!!");
           game.players[3].setBlackjacked(true);
           mx++;
           //System.out.println(mx);
          if(mx == 1)
               System.exit(0);
       }
       while ( !game.players[3].isBusted()&& !game.players[3].isBlackjacked()) {
           if (score == 21  ||game.players[3].getScore() > game.maxScore()  ) {
               System.out.println(game.players[3].getName() + " Has Won!");
               game.players[3].setBlackjacked(true);
               mx ++;
               break;
               // System.exit(0);
           }

          // System.out.println("Score Of the Btengana = " + game.players[3].getScore());

               game.players[3].cards[game.players[3].cardNumber] = game.cardDraw(game.players[3], 3);
               gui.updateDealerHand(game.players[3].cards[game.players[3].cardNumber], game.cardDeck);
               score += game.players[3].cards[game.players[3].cardNumber].getValue();
               game.players[3].setScore(game.players[3].cards[game.players[3].cardNumber].getValue());
               game.players[3].cardNumber++;



           if (score > 21) {

               System.out.println(game.players[3].getName() + " Got BUSTED!");
               //ySystem.out.println("Dealer BUSTED!");
               game.players[3].setBusted(true);
           }
           //Systbem.out.println("Dealer Won");


       }
       if(mx > 1 )
       {
           System.out.println("More than One Player Won (PUSH)");
           //System.exit(0);
       }
       else if(!game.players[0].isBusted() && game.players[1].isBusted() && game.players[2].isBusted() && game.players[3].isBusted())
       {
           System.out.println(game.players[0].getName() + " Has Won!");//System.exit(0);
       }
      else if(game.players[0].isBusted() && !game.players[1].isBusted() && game.players[2].isBusted() && game.players[3].isBusted())
       {
           System.out.println(game.players[1].getName() + " Has Won!");//System.exit(0);
       }
       else if(game.players[0].isBusted() && game.players[1].isBusted() && !game.players[2].isBusted() && game.players[3].isBusted())
       {
           System.out.println(game.players[2].getName() + " Has Won!");//System.exit(0);
       }

       else
       {
           int maxScoreAtMostValidyk = 0,num = 0,index = -1;
           boolean push = false;

           for(int i = 0 ; i<4 ; i ++)
           {
               if(game.players[i].getScore() > maxScoreAtMostValidyk && game.players[i].getScore() <= 21)
               {
                   maxScoreAtMostValidyk = game.players[i].getScore();
               }
           }
           for(int i = 0 ; i<4 ; i ++)
           {
               if(game.players[i].getScore() == maxScoreAtMostValidyk )
               {
                   num ++;
                   index = i;
               }
               if(num > 1)
               {
                   push = true;
                   break;
               }

           }
           if(push)
           {
               System.out.println("PUSH");//System.exit(0);
           }

          else {
                if(!game.players[index].isBlackjacked())
               System.out.println(game.players[index].getName() + " Has Won!");//System.exit(0);
           }


       }
       //System.exit(0);
   }
}
