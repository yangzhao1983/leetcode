package zy.leetcode.backtracking.solution95;

import apple.laf.JRSUIUtils;
import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return doGenerateTrees(1, n);
    }

    private List<TreeNode> doGenerateTrees(int start, int end){

        List<TreeNode> list = new ArrayList<>();

        if(start == end){
            TreeNode tn = new TreeNode(start);
            list.add(tn);
        }else if(start < end){
            for(int i = start; i <= end; i++){
                List<TreeNode> left = doGenerateTrees(start, i-1);
                List<TreeNode> right = doGenerateTrees(i+1, end);
                int j=0, k=0;
                if(left.size() == 0){
                    j = -1;
                }

                for(; j < left.size(); j++){
                    if(right.size()==0){
                        k= -1;
                    }else{
                        k= 0;
                    }
                    for(; k < right.size();k++){
                        TreeNode root = new TreeNode(i);
                        if(j==-1){
                            root.left = null;
                        }else{
                            root.left = left.get(j);
                        }

                        if(k==-1){
                            root.right = null;
                        }else{
                            root.right = right.get(k);
                        }
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        List<TreeNode> list = sol.generateTrees(4);
        System.out.println();
    }

}
