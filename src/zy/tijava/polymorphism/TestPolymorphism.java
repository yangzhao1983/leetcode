package zy.tijava.polymorphism;

import java.util.Random;

/**
 * Created by kaiser_zhao on 07/04/2019.
 */
public class TestPolymorphism {
    private static Random random = new Random(47);

    public static void tune(Instrument i){
        i.play(Note.MIDOLE_C);
    }

    public static void tuneAll(Instrument[] e){
        for(Instrument i : e){
            tune(i);
        }
    }

    public static void main(String...strings){
        Instrument[] orchestra = {
                new Percussion(),
                new Wind()
        };
        System.out.println("string is " + new Wind());

        for (int num = 0; num < 5; num++){
            System.out.println(nextInstrument());
        }
    }

    private static Instrument nextInstrument(){

        int randomInt = random.nextInt(2);
        System.out.println(randomInt);
        switch (randomInt){
            case 0 : return new Percussion();
            case 1 :
            default: return new Wind();
        }
    }
}

enum Note{
    MIDOLE_C, C_SHARP, B_FLAT;
}

class Instrument {
    void play(Note n){
        System.out.println("Instrument.play " + n);
    }

    public String toString(){
        return "Instrument";
    }
}

class Percussion extends Instrument{
    void play(Note n){
        System.out.println("Percussion.play " + n);
    }

    public String toString(){
        return "Percussion";
    }
}

class Wind extends Instrument{
    void play(Note n){
        System.out.println("Wind.play " + n);
    }

    public String toString(){
        return "Wind";
    }
}