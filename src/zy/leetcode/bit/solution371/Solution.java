package zy.leetcode.bit.solution371;

public class Solution {
    public int getSum(int a, int b) {
        int remainder = a ^ b;
        int carry = (a & b) << 1;
        while(carry != 0){
            int temp = remainder;
            remainder = remainder ^ carry;
            carry = (temp & carry) <<1;
        }
        return remainder;
    }
}
