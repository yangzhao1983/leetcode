package zy.leetcode;

/**
 * Created by kaiser_zhao on 2018/10/19.
 */
public class Solution12 {
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
     * num > 3999 ==> 0
     * num <=0 ===> 0
     *
     * i=0, left ->(I, V, X)
     * num%10
     * num = num/10
     *
     * i=1, left ->(X, L, C, X)
     * num%10
     * num = num /10
     *
     * i=2, left ->(C, D, M, C)
     * num%10
     * num = num /10
     *
     * i=3, left ->(I, M)
     * num%10
     * num = num /10
     *
     * 0. 1, 10, 100, One(i)
     * 1. 2,3  left + One(i)
     * 2. 4, (One(i)+Five(i))
     * 3. 5, Five(i) + One(i)
     * 4. 6,7,8 Five(i) + (left-5)One(i)
     * 5. 9, One(i) + One(i+1)
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        String rel = "";
        if(num==0){
            return "";
        }

        int i = 0;
        while(num>0){
            int left = num % 10;
            switch(left){
                case 0: break;
                case 1:
                case 2:
                case 3: rel = one(left,i) + rel; break;
                case 4: rel = one(1,i) + five(i) + rel; break;
                case 5: rel = five(i) + rel;break;
                case 6:
                case 7:
                case 8: rel = five(i) + one(left - 5, i) + rel;   break;
                case 9: rel = one(1,i) + one(1, i+1) + rel; break;
            }
            num = num /10;
            i++;
        }
        return rel;
    }

    public static void main(String...strings){
        System.out.println(intToRoman(0));
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(100));
        System.out.println(intToRoman(1000));

        System.out.println(intToRoman(4));
        System.out.println(intToRoman(40));
        System.out.println(intToRoman(400));

        System.out.println(intToRoman(5));
        System.out.println(intToRoman(50));
        System.out.println(intToRoman(500));

        System.out.println(intToRoman(9));
        System.out.println(intToRoman(90));
        System.out.println(intToRoman(900));

        System.out.println(intToRoman(2));
        System.out.println(intToRoman(30));
        System.out.println(intToRoman(200));

        System.out.println(intToRoman(12));
        System.out.println(intToRoman(345));
        System.out.println(intToRoman(3999));
    }

    private static String five(int i){

        String five = "";
        if(i==0){
            five = "V";
        }else if(i==1){
            five = "L";
        }else if (i==2){
            five = "D";
        }

        return five;
    }

    private static String one(int left, int i){
        if(left==0){
            return "";
        }
        String one = "";
        if(i==0){
            one = "I";
        }else if(i==1){
            one = "X";
        }else if (i==2){
            one = "C";
        }else{
            one = "M";
        }

        String rel = "";
        for(int j =1; j<=left;j++){
            rel += one;
        }
        return rel;
    }
}
