package zy.leetcode.array.solution914;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] cards = new int[1000];
        for(int card : deck){
            cards[card]++;
        }

        int p = -1;
        for(int cardNum : cards){
            if(cardNum < 1){
                continue;
            }

            if(p == -1){
                p = cardNum;
            }else{
                p = gcd(cardNum, p);
            }
        }

        return p >= 2;
    }

    private int gcd(int x, int y){
        return x==0? y : gcd(y%x, x);
    }

    private static void test1(){
        int[] deck = new int[] {1,2,3,4,4,3,2,1};
        Solution sol = new Solution();
        System.out.println(sol.hasGroupsSizeX(deck));
    }

    private static void test2(){
        int[] deck = new int[] {1,1,1,2,2,2,3,3};
        Solution sol = new Solution();
        System.out.println(sol.hasGroupsSizeX(deck));
    }

    private static void test3(){
        int[] deck = new int[] {1,1,2,2,2,2};
        Solution sol = new Solution();
        System.out.println(sol.hasGroupsSizeX(deck));
    }
    public static void main(String...strings){
        test1();
        test2();
        test3();
    }
}
