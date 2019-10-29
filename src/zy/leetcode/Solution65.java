package zy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaiser_zhao on 12/06/2019.
 */
public class Solution65 {
    public static void main(String...strings){

        System.out.println(isNumber("0"));
        System.out.println(isNumber(" 0.1"));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("1 a"));
        System.out.println(isNumber("2e10"));
        System.out.println(isNumber(" -90e3   "));
        System.out.println(isNumber(" 1e"));
        System.out.println(isNumber("e3"));
        System.out.println(isNumber("6e-1"));
        System.out.println(isNumber("99e2.5"));
        System.out.println(isNumber("53.5e93"));
        System.out.println(isNumber("--6"));
        System.out.println(isNumber("-+3"));
        System.out.println(isNumber("95a54e53"));
        System.out.println(isNumber("95+3"));
        System.out.println(isNumber(".1"));
        System.out.println(isNumber("+.1"));
        System.out.println(isNumber("+.+"));
        System.out.println(isNumber("1."));
        System.out.println(isNumber("."));
        System.out.println(isNumber(". 1"));
        System.out.println(isNumber("46.e3"));
        System.out.println(isNumber(".e3"));
    }

    public static boolean isNumber(String s) {
        if(s == null){
            return false;
        }

        s = s.trim();
        if(s.length() == 0){
            return false;
        }

        Set<Character> numbers = new HashSet<Character>();
        for(char c = '0'; c<='9'; c++) {
            numbers.add(c);
        }

        boolean numberStarted = false;
        boolean endPointed = false;
        boolean pointed = false;
        boolean pointStarted =false;
        boolean eStart = false;
        boolean signed = false;
        char[] cs = s.toCharArray();
        for(int i = 0; i<cs.length; i++){
            if(cs[i] != ' '){
                if(cs[i] == '+' || cs[i] == '-'){
                    if(i>0 && !(i>0 && cs[i-1] == 'e')){
                        return false;
                    }
                    signed = true;
                }else if(numbers.contains(cs[i])){
                    if(!numberStarted){
                        numberStarted = true;
                    }
                    if(pointed){
                        endPointed = true;
                    }
                }else if(cs[i] == '.'){
                    if (pointed){
                        return false;
                    }
                    if(eStart){
                        return false;
                    }
                    if(!numberStarted){
                        pointStarted = true;
                        numberStarted = true;
                    }
                    pointed = true;
                }else if (cs[i] == 'e'){
                    if(!numberStarted){
                        return false;
                    }
                    if(pointStarted && !endPointed){
                        return false;
                    }
                    if(eStart){
                        return false;
                    }
                    eStart = true;
                }else{
                    return false;
                }
            }else{
                if(signed || numberStarted){
                    return false;
                }
            }
        }
        if(eStart && !numbers.contains(cs[cs.length-1])){
            return false;
        }
        if(pointStarted && !numbers.contains(cs[cs.length-1])){
            return false;
        }

        return true;
    }
}
