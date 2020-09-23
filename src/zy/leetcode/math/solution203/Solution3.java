package zy.leetcode.math.solution203;

import java.util.Arrays;

public class Solution3 {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int cnt = 0;
        boolean[] bs = new boolean[n];
        Arrays.fill(bs, true);
        for(int i = 2; i * i <n; i++){
            if(!bs[i]) continue;
            int fac = i + i;
            while(fac < n){
                bs[fac] = false;
                fac +=i;
            }
        }
        for(int i = 2; i <n; i++){
            if(bs[i]) cnt++;
        }
        return cnt;
    }
}
