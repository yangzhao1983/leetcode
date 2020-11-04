package zy.leetcode.divideconquer.solution241;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> opPoss;
    private String input;

    public List<Integer> diffWaysToCompute(String input) {
        opPoss = new ArrayList<>();
        this.input = input;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                opPoss.add(i);
            }
        }
        List<Integer> ans = doDivideConquer(0, opPoss.size() - 1, 0, input.length() - 1);
        return ans;
    }

    private List<Integer> doDivideConquer(int so, int eo, int ss, int es) {
        List<Integer> rel = new ArrayList<>();

        if (eo < 0 || so== opPoss.size()|| ss > opPoss.get(eo) || es < opPoss.get(so)) {
            rel.add(Integer.parseInt(input.substring(ss, es + 1)));
            return rel;
        }

        // divide
        for (int i = so; i <= eo; i++) {

            // left partition
            List<Integer> l = doDivideConquer(so, i-1, ss, opPoss.get(i) - 1);

            // right partition
            List<Integer> r = doDivideConquer(i+1, eo, opPoss.get(i) + 1, es);
            char c = input.charAt(opPoss.get(i));

            for (int li : l) {
                for (int ri : r) {
                    if (c == '+') {
                        rel.add(li + ri);
                    } else if (c == '-') {
                        rel.add(li - ri);
                    } else {
                        rel.add(li * ri);
                    }
                }
            }
        }
        return rel;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<Integer> list = sol.diffWaysToCompute("2-1-1");
        System.out.println();
    }
}
