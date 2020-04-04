package zy.leetcode.math.solution43;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 ==null || num1.length() == 0 || num2.length()==0){
            return "0";
        }

        if(num1.length() < num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        String[] projects = new String[num2.length()];
        String ans = "0";
        for(int i = num2.length()-1; i>=0 ; i--){
            String zeros = "";
            for(int j =0; j < num2.length()-i-1;j++ ){
                zeros += "0";
            }
            projects[i] = multiplySingle(num1, num2.substring(i,i+1))+ zeros;
        }
        for(int i = 0; i < projects.length; i++){
            ans = plus(projects[i], ans);
        }
        return ans;
    }

    /**
     * num2 has only one digit
     *
     * c1c2c3..cn
     * a
     *
     * a X cn + left = bn,
     * if b1 >= 10, rel = (b1-10)+rel,
     * left = 1
     *
     * left + rel
     *
     * @param num1
     * @param num2
     * @return
     */
    private String multiplySingle(String num1,String num2){
        int project = 0;
        int left = 0;
        String rel = "";
        int i = num1.length()-1;
        int intNum2 = num2.charAt(0) - '0';
        if(intNum2 == 0){
            return "0";
        }else if(intNum2 == 1){
            return num1;
        }

        int right = num2.charAt(0) - '0';
        while(i >= 0){
            project = left + (num1.charAt(i) - '0')*right;
            if(project >= 10){
                left = project/10;
                rel = project%10 + rel;
            }else{
                rel = project + rel;
                left=0;
            }
            i--;
        }
        if(left > 0){
            rel = left + rel;
        }
        return rel;
    }

    /**
     * a1a2a3...an
     * b1b2b3...bm
     *
     * an + bm + left = ck
     * if ck >=10, rel = (ck-10) + rel
     * if m<0,
     * an + left
     *
     * if left = 0
     * rel = a/b left + rel
     *
     * @param num1
     * @param num2
     * @return
     */
    private String plus(String num1, String num2){
        String rel = "";
        int sum = 0;
        int left = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        if(num2=="0"){
            return num1;
        }else if(num1 == "0"){
            return num2;
        }

        while(i >= 0 && j>=0){
            sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + left;
            if(sum >= 10){
                left = 1;
                rel = (sum - 10) + rel;
            }else{
                rel = sum + rel;
                left = 0;
            }
            i--;
            j--;
        }

        if(i < 0){
            while(j >=0 ){
                sum = left + (num2.charAt(j) - '0');
                if(sum >= 10){
                    left = 1;
                    rel = (sum - 10) + rel;
                }else{
                    rel = sum + rel;
                    left = 0;
                }
                j--;
            }
        }else if(j < 0){
            while(i >=0 ){
                sum = left + (num1.charAt(i) - '0');
                if(sum >= 10){
                    left = 1;
                    rel = (sum - 10) + rel;
                }else{
                    rel = sum + rel;
                    left = 0;
                }
                i--;
            }
        }

        if(left == 1){
            rel = 1 + rel;
        }

        return rel;
    }

//    @Test
//    public void test1(){
//        Solution sol = new Solution();
//        Assert.assertEquals("6", sol.multiply("2","3"));
//    }
//
//    @Test
//    public void test2(){
//        Solution sol = new Solution();
//        Assert.assertEquals("0", sol.multiply("0","3"));
//    }
//
//    @Test
//    public void test3(){
//        Solution sol = new Solution();
//        Assert.assertEquals("56088", sol.multiply("123","456"));
//    }

    @Test
    public void test4(){
        Solution sol = new Solution();
        Assert.assertEquals("0", sol.multiply("0","52"));
    }
}
