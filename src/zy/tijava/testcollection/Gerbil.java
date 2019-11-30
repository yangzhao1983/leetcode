package zy.tijava.testcollection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaiser_zhao on 21/04/2019.
 */
public class Gerbil {
    private static int gerbilCount = 0;
    private int gerbilNumber = ++gerbilCount;
    private String name;
    public Gerbil(String name){
        System.out.println("Gerbil " + name + " number is " + gerbilNumber);
    }

    public static void main(String... strings){
        Gerbil g1 = new Gerbil("c");
        Gerbil g2 = new Gerbil("b");
        Gerbil g3 = new Gerbil("a");

        Map<String, Gerbil> gs = new HashMap<>();
        for (String name : gs.keySet()){
            System.out.println(gs.get(name));
        }
    }
}
