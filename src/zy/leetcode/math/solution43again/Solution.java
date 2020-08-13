package zy.leetcode.math.solution43again;

public class Solution {
    public String multiply(String num1, String num2) {
        String ans = "";
        if(num1 == null || num1.length()==0){
            return num2;
        }
        if(num2 == null || num2.length()==0){
            return num1;
        }
        for(int i = num2.length()-1; i >=0 ;i--){
            String project = singleMultiply(num1,num2.substring(i,i+1),num2.length()-1-i);
            ans = add(ans, project);
        }
        return ans;
    }

    // "12" + "120" = "132"
    private String add(String l, String r){
        int remain = 0;
        int m = l.length();
        int n = r.length();
        int max = Math.max(m,n);
        int i = 0;
        String rel = "";
        while(i< max){
            int intL = (i>= m? 0 : Integer.parseInt(l.substring(m-i-1, m-i)));
            int intR = (i>= n? 0 : Integer.parseInt(r.substring(n-i-1, n-i)));
            int sum = intL + intR + remain;
            rel = Integer.toString(sum%10) + rel;
            remain = sum/10;
            i++;
        }
        if(remain > 0){
            rel = Integer.toString(remain) + rel;
        }
        return rel;
    }

    // "12" * "2" = "24"
    private String singleMultiply(String l, String r, int index){
        if(l.equals("0") || r.equals("0")) return "0";
        String rel = "";
        int remain = 0;
        int intR = Integer.parseInt(r);
        for(int i = l.length()-1; i>=0; i--){
            int intL = Integer.parseInt(l.substring(i,i+1));
            int sum = remain + intR * intL;
            rel = Integer.toString(sum%10) + rel;
            remain = sum/10;
        }

        if(remain > 0){
            rel = Integer.toString(remain) + rel;
        }

        for(int i = 0; i < index;i++){
            rel = rel + "0";
        }

        return rel;
    }
}
