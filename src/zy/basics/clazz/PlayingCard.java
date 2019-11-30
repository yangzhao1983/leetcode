package zy.basics.clazz;

/**
 * Created by kaiser_zhao on 2/22/18.
 */
public class PlayingCard {

    public PlayingCard(){
        this("Diamond", "A");
    }

    public PlayingCard(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    private String suit;
    private String rank;

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {

        return suit;
    }

    public String getRank() {
        return rank;
    }
}
