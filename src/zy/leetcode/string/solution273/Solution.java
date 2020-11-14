package zy.leetcode.string.solution273;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * mod 1000:
     * divide by 1000
     * mod twice: + " Thousand " + s
     * mod third time: + " Million " + s
     * mod forth time: + " Billion " + s
     *
     * for string after mod:
     * divide by 100, > 0, num + " Hundred "
     * mod 100
     * divide by 10, > 1,
     * 2: twenty,
     * 3: thirty
     * 4: forty
     * 5: fifty
     * 6: sixty
     * 7: seventy
     * 8: eighty
     * 9. ninety
     *
     * mod 10:
     * 1: one
     * 2: two
     * 3: three
     * 4: four..
     *
     * 1:
     * 11
     * 12
     * 13
     *
     * @param num
     * @return
     */
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int time = 0;
        int lessThan1000;
        String ans = "";
        String single = "";
        Map<Integer, String> tens = new HashMap<>();
        Map<Integer, String> units = new HashMap<>();
        Map<Integer, String> tensOne = new HashMap<>();

        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");

        units.put(1, "One");
        units.put(2, "Two");
        units.put(3, "Three");
        units.put(4, "Four");
        units.put(5, "Five");
        units.put(6, "Six");
        units.put(7, "Seven");
        units.put(8, "Eight");
        units.put(9, "Nine");

        tensOne.put(10, "Ten");
        tensOne.put(11,"Eleven");
        tensOne.put(12,"Twelve");
        tensOne.put(13,"Thirteen");
        tensOne.put(14,"Fourteen");
        tensOne.put(15,"Fifteen");
        tensOne.put(16,"Sixteen");
        tensOne.put(17,"Seventeen");
        tensOne.put(18,"Eighteen");
        tensOne.put(19,"Nineteen");

        while(num > 0){
            single = "";
            lessThan1000 = num%1000;
            if (lessThan1000 >= 100) {
                int hundred = lessThan1000/100;
                if(hundred > 0) single = units.get(hundred) + " Hundred";
            }

            lessThan1000 %= 100;
            if(lessThan1000 >=10){
                int ten = lessThan1000/10;
                if(ten > 1){
                    single = (single.equals("")? "":(single + " ")) + tens.get(ten);
                }else if(ten == 1){
                    single = (single.equals("")? "":(single + " ")) + tensOne.get(lessThan1000);
                }
            }

            if(lessThan1000>= 20 ||lessThan1000 <10){
                lessThan1000 %=10;
                if(lessThan1000 > 0) single = (single.equals("")? "":(single + " ")) + units.get(lessThan1000);
            }

            if (!single.equals("")) {
                if(time==1) single += " Thousand";
                else if (time==2) single += " Million";
                else if(time==3) single += " Billion";
            }
            if(ans.equals("")) ans = single;
            else if(!single.equals("")) ans = single + " " +ans;
            time++;
            num = num/1000;
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        Assert.assertEquals("One Hundred Twenty Three", sol.numberToWords(123));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", sol.numberToWords(1234567));
    }
}
