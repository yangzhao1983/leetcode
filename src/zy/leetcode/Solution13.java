package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/20.
 */
public class Solution13 {
    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * IV           4
     * IX           9
     *
     * Context:
     *  given one char, "ONE", "FIVE", "NEXT_ONE",
     * Map:
     *  given one char, value
     *
     * Hit one:
     *  one [1-3]
     *  one [1] five
     *  one [1] one(i+1)[1]
     * Hit five:
     *  five[1]
     *  five[1]one[1-3]
     */
    private static char[] getContext (char c){
        switch(c){
            case 'I':
            case 'V': return new char[]{'I', 'V', 'X'};
            case 'X':
            case 'L': return new char[]{'X','L', 'C'};
            case 'C':
            case 'D': return new char[]{'C','D','M'};
            case 'M': return new char[]{'M', '@' ,'@'};
            default: return null;
        }
    }

    private static int getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int romanToInt(String s) {
        int rel = 0;
        for(int i = 0; i< s.length();){
            char curC = s.charAt(i);
            char[] context = getContext(curC);

            if(s.charAt(i)==context[0]){
                // is one
                if(i==s.length()-1){
                    rel = getValue(context[0]) + rel;
                    i++;
                }else if (s.charAt(i+1)==context[1]){
                    // deal with 4
                    rel = rel + getValue(context[1]) - getValue(context[0]);
                    i = i+2;
                }else if (s.charAt(i+1) == context[2]){
                    rel = rel + getValue(context[2]) - getValue(context[0]);
                    i = i+2;
                }else{
                    int j = 0;
                    for(;j<3 && j + i <s.length();j++){
                        if(s.charAt(i+j)==context[0]){
                            rel = rel + getValue(context[0]);
                        }else{
                            break;
                        }
                    }
                    i = i+j;
                }
            }else {
                // is five
                rel = getValue(context[1]) + rel;
                int j = 1;
                for(; j<4 && i+j<s.length() ;j++){
                    if(s.charAt(i+j)==context[0]){
                        rel = rel + getValue(context[0]);
                    }else{
                        break;
                    }
                }
                i = i + j;
            }
        }
        return rel;
    }
    /**
         * I             1
            * V             5
            * X             10
            * L             50
            * C             100
            * D             500
            * M             1000
            *
            * IV           4
            * IX           9
     */
    public static void main(String...strings){
//        System.out.println(romanToInt("I")==1);
//        System.out.println(romanToInt("V")==5);
//        System.out.println(romanToInt("X")==10);
//        System.out.println(romanToInt("L")==50);
//        System.out.println(romanToInt("C")==100);
//        System.out.println(romanToInt("D")==500);
//        System.out.println(romanToInt("M")==1000);
//        System.out.println(romanToInt("IV")==4);
//        System.out.println(romanToInt("XL")==40);
//        System.out.println(romanToInt("CD")==400);
//        System.out.println(romanToInt("IX")==9);
//        System.out.println(romanToInt("XC")==90);
//        System.out.println(romanToInt("CM")==900);
//        System.out.println(romanToInt("III")==3);
//        System.out.println(romanToInt("XXX")==30);
//        System.out.println(romanToInt("CCC")==300);
//        System.out.println(romanToInt("MMM")==3000);
//        System.out.println(romanToInt("VII")==7);
//        System.out.println(romanToInt("LX")==60);
//        System.out.println(romanToInt("DCCC")==800);
//        System.out.println(romanToInt("XIV")==14);
//        System.out.println(romanToInt("LVIII")==58);
//        System.out.println(romanToInt("LVIII")==58);
        System.out.println(romanToInt("CMLII"));
    }
}
