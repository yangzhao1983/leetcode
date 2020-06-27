package zy.leetcode.design.solution297;

import org.junit.Assert;
import org.junit.Test;
import zy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String serial = "";
        if(root == null) return serial;
        boolean start = false;
        TreeNode dummy = new TreeNode(-1);
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        LinkedList<TreeNode> lastLayer = new LinkedList<>();
        while (!q.isEmpty()) {
            int len = q.size();
            while(!lastLayer.isEmpty()){
                if(start) serial += ",";
                else start = true;
                TreeNode c = lastLayer.pollLast();
                serial += c==dummy ? "@" : String.valueOf(c.val);
            }
            int cnt = 0;
            while (len > 0) {
                TreeNode cur = q.pollLast();
                lastLayer.addFirst(cur);
                if(cur!=dummy){
                    if(cur.left == null) cnt++;
                    q.addFirst(cur.left == null ? dummy : cur.left);
                    if(cur.right == null) cnt++;
                    q.addFirst(cur.right == null ? dummy : cur.right);
                }
                len--;
            }
            if(cnt == q.size()) q.clear();
        }
        while(lastLayer.peekFirst()==dummy) {
            lastLayer.pollFirst();
        };
        while(!lastLayer.isEmpty()){
            TreeNode c = lastLayer.pollLast();
            if(start) serial += ",";
            else start = true;
            serial += c==dummy ? "@" : String.valueOf(c.val);
        }
        return serial;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)) return null;

        Deque<TreeNode> q = new ArrayDeque<>();
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.addFirst(root);
        int widthCurLayer = 2;
        int widthNextLayer = 0;
        int i = 1;
        while(i < vals.length){
            int j = 0;
            while(j < widthCurLayer && i < vals.length){
                int k = q.size();
                while(k >0){
                    TreeNode parent = q.pollLast();
                    TreeNode l =  "@".equals(vals[i])? null : new TreeNode(Integer.parseInt(vals[i]));
                    parent.left = l;
                    if(l != null){
                        q.addFirst(l);
                        widthNextLayer+=2;
                    }
                    j++;
                    i++;
                    if(j == widthCurLayer || i==vals.length) break;
                    TreeNode r =  "@".equals(vals[i])? null : new TreeNode(Integer.parseInt(vals[i]));
                    parent.right = r;
                    if(r != null){
                        q.addFirst(r);
                        widthNextLayer += 2;
                    }
                    j++;
                    i++;
                    k--;
                    if(j == widthCurLayer || i==vals.length) break;
                }
                widthCurLayer = widthNextLayer;
            }
        }

        return root;
    }

    @Test
    public void test1(){
        String s = "1,2,3,@,@,4,5";
        Solution sol = new Solution();
        TreeNode root = sol.deserialize(s);
        System.out.println(root);
        Assert.assertEquals("1,2,3,@,@,4,5",sol.serialize(root));
    }

    @Test
    public void test2(){
        String s = "1,3,@,@,4";
        Solution sol = new Solution();
        TreeNode root = sol.deserialize(s);
        System.out.println(root);
        Assert.assertEquals("1,3,@,@,4",sol.serialize(root));
    }

    @Test
    public void test3(){
        String s = "1";
        Solution sol = new Solution();
        TreeNode root = sol.deserialize(s);
        System.out.println(root);
        Assert.assertEquals("1",sol.serialize(root));
    }

    @Test
    public void test4(){
        String s = "5,2,3,@,@,2,4,3,1";
        Solution sol = new Solution();
        TreeNode root = sol.deserialize(s);
        System.out.println(root);
        Assert.assertEquals("5,2,3,@,@,2,4,3,1",sol.serialize(root));
    }
}
