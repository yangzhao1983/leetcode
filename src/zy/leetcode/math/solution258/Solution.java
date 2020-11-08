package zy.leetcode.math.solution258;

public class Solution {
    /**
     * 0:0,1:1,...9:9
     * 10:1, 11:2, 13:4,...19:0
     * 20:2,21:3,........29:1
     * 90:9,91:0,.......99:8
     * 100:1,101:2,...,109:0
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return (num-1)%9 +1;
    }
}
