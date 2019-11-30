package zy.basics.clazz;

import java.util.*;

/**
 * Created by kaiser_zhao on 2/22/18.
 */
public class Deck {

    private final static String DIAMONDS = "DIAMONDS";
    private final static String CLUBS = "CLUBS";
    private final static String HEARTS = "HEARTS";
    private final static String SPADES = "SPADES";

    private List<PlayingCard> cards = new ArrayList<PlayingCard>();

    public static void main(String... strings){
        Deck deck = new Deck();
        for(int i = 0; i < deck.getCards().size(); i++){
            System.out.println("[" + deck.getCards().get(i).getSuit() + "," + deck.getCards().get(i).getRank() + "]");
        }
    }

    public List<PlayingCard> getCards() {
        return cards;
    }

    public Deck(){
        String suit = null;
        String rank = null;
        for(int i = 0; i<4; i++ ){
            suit = this.getSuit(i);
            for(int j = 0; j<13; j++){
                rank = this.getRank(j);
                cards.add(new PlayingCard(suit, rank));
            }
        }
        //Collections.shuffle(cards, new Random());
    }

    private String getSuit(int index){
        String suit = null;
        switch (index){
            case 0:
                suit = DIAMONDS;
                break;
            case 1:
                suit = CLUBS;
                break;
            case 2:
                suit = HEARTS;
                break;
            default:
                suit = SPADES;
                break;
        }
        return suit;
    }


    private String getRank(int index){
        String rank = null;
        switch (index){
            case 0:rank = "A";
                break;
            case 1:rank = "2";
                break;
            case 2:rank = "3";
                break;
            case 3:rank = "4";
                break;
            case 4:rank = "5";
                break;
            case 5:rank = "6";
                break;
            case 6:rank = "7";
                break;
            case 7:rank = "8";
                break;
            case 8:rank = "9";
                break;
            case 9:rank = "10";
                break;
            case 10:rank = "J";
                break;
            case 11:rank = "Q";
                break;
            default:rank = "K";
                break;
        }
        return rank;
    }
}
