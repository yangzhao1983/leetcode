package zy.leetcode.tree.solution679;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int TARGET = 24;
    private double EPSILON = 0.000001;

    public boolean judgePoint24(int[] nums) {
        List<Double> mem = new ArrayList<>();
        for(int num : nums){
            mem.add((double)num);
        }
        return doJudge(mem);
    }

    private boolean doJudge(List<Double> mem){
        if (mem.size() == 0) {
            return false;
        }

        if(mem.size()==1) return Math.abs(mem.get(0) - TARGET) < EPSILON;
        // mem.size = 4
        // mem.size = 3
        // mem.size = 2
        // select 2 nums
        for(int i = 0; i < mem.size(); i++){
            for(int j = 0; j < mem.size(); j++){
                if(i!=j){
                    List<Double> newList =new ArrayList<>();
                    for(int k = 0; k <mem.size(); k++){
                        if(k!=j && k!=i){
                            newList.add(mem.get(k));
                        }
                    }

                    // plus
                    newList.add(mem.get(i) + mem.get(j));
                    if(doJudge(newList)) return true;
                    newList.remove(newList.size()-1);

                    // multiply
                    newList.add(mem.get(i) * mem.get(j));
                    if(doJudge(newList)) return true;
                    newList.remove(newList.size()-1);

                    // minus
                    newList.add(mem.get(i) - mem.get(j));
                    if(doJudge(newList)) return true;
                    newList.remove(newList.size()-1);

                    // divide
                    if(mem.get(j)>EPSILON){
                        newList.add(mem.get(i) / mem.get(j));
                        if(doJudge(newList)) return true;
                        newList.remove(newList.size()-1);
                    }
                }
            }
        }
        return false;
    }
}
