package zy.leetcode.stack.solution1028;

import org.junit.Assert;
import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.Stack;

public class Solution {
    /**
     * count num of -, until hit number.
     * parse the number.
     * if countH == stack.size, it's the left child of the top item.
     *  push it to stack.
     * if countH < stack.size,
     *  pop stack until stack.size == countH, it's the right child of the top item.
     *
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack =  new Stack<>();
        TreeNode ans = null;
        int cnt =0;
        for(int i = 0; i <S.length(); i++){
            if(S.charAt(i)=='-'){
                cnt++;
            }else{
                int j = i;
                int val = 0;
                while(j<S.length() && S.charAt(j)!='-'){
                    val = val * 10 + S.charAt(j) - '0';
                    j++;
                }
                i = j-1;
                TreeNode node = new TreeNode(val);

                if(cnt == stack.size()){
                    if(cnt > 0){
                        stack.peek().left = node;
                    }else{
                        ans = node;
                    }
                }else{
                    while(cnt < stack.size()){
                        stack.pop();
                    }
                    stack.peek().right = node;
                }
                stack.add(node);
                cnt = 0;
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        Solution sol = new Solution();
        TreeNode root = sol.recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println();
    }

    @Test
    public void test2(){
        Solution sol = new Solution();
        TreeNode root = sol.recoverFromPreorder("1-401--349---90--88");
        System.out.println();
    }
}
