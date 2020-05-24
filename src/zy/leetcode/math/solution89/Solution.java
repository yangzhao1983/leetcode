package zy.leetcode.math.solution89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int head = 0;
        for(int i = 1; i <= n; i++){
            head <<= 1;
            for(int j = ans.size() - 1; j >= 0; j--){
                ans.add(head + ans.get(j));
            }
        }
        return ans;
    }
}
