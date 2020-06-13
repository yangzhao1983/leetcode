package zy.leetcode.array.solution118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        if(numRows == 0){
            return ans;
        }

        List<Integer> list = new ArrayList<>();

        list.add(1);
        ans.add(list);
        for(int i = 1; i < numRows;i++){
            list = new ArrayList<>();
            list.add(1);
            for(int j = 1; j <= i/2; j++){
                list.add(ans.get(ans.size()-1).get(j-1) + ans.get(ans.size()-1).get(j));
            }

            for(int j = (i-1)/2; j>=0; j--){
                list.add(new Integer(list.get(j)));
            }
            ans.add(list);
        }

        return ans;
    }
}
