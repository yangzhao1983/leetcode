package zy.leetcode.string.solution696;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    /**
     * fp:
     * init:
     * fp = 0
     * sp = 0
     * first_cnt = 0
     * second_cnt = 0
     *
     * sp moves forward: s[sp] is the first char which is different from s[fp]
     *
     * number of chars that are equal to s[fp]: first_cnt = sp - fp
     *
     * ans+= min(first_cnt, second_cnt)
     * first_cnt = second_cnt
     * sp = fp
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        if(s==null || s.length() <2 ) return 0;

        int ans = 0;

        int fp, sp, firstCnt, secondCnt;
        firstCnt = secondCnt = fp = sp = 0;
        while(sp < s.length()){
            while(sp <s.length() && s.charAt(sp) == s.charAt(fp)) sp ++;
            secondCnt = sp - fp;
            ans += Math.min(firstCnt, secondCnt);
            fp = sp;
            firstCnt = secondCnt;
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        String s = "00110";
        Assert.assertEquals(3, sol.countBinarySubstrings(s));
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        String s = "0011";
        Assert.assertEquals(2, sol.countBinarySubstrings(s));
    }
}
