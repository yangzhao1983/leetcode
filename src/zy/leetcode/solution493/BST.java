package zy.leetcode.solution493;

/**
 * Created by kaiser_zhao on 25/07/2019.
 */
public class BST {

    public static void main(String...strings){
//        System.out.println(Math.pow(2,31));
        int[] a = {1,3,2,3,1};
        int[] a1 = {2,4,3,5,1};
        System.out.println(reversePairs(a));
        System.out.println(reversePairs(a1));
//        int[] a2 = {7,4,3,5,1};
//        System.out.println(reversePairs(a2));
//        int[] a3 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
//        System.out.println(reversePairs(a3));
    }

    private static int reversePairs(int[] nums){
        if(nums==null || nums.length <2){
            return 0;
        }
        BSTNode root = null;

        int sum = 0;
        for(int i = 0; i <nums.length; i++){
            sum += searchNode(nums[i] * 2L + 1, root);
            root = insertNode(nums[i], root);
        }
        return sum;
    }

    private static BSTNode insertNode(int val, BSTNode cur){

        // search from current
        // if val > cur.val, cur.countGE++, if cur.right = null, cur.right=val; else, insert val to cur.right
        // if val = cur.val, curl.countGE++, return
        // if val < cur.val, node.countGE, if cur.left = null, cur.left = val; else, insert val to cur.left.
        if(cur == null){
            return new BSTNode(val);
        }

        if(val == cur.val){
            cur.countGE ++;
        }else if(val > cur.val){
            cur.countGE ++;
            cur.right = insertNode(val, cur.right);
        }else{
            cur.left = insertNode(val, cur.left);
        }
        return cur;
    }

    private static int searchNode(long val, BSTNode cur){
        int count = 0;

        if(cur==null){
            return 0;
        }

        if(cur.val == val){
            return cur.countGE;
        }

        // if val > cur.val, search for cur.right
        // if val < cur.val, search for cur.left, count=count + cur.countGE
        if(val > cur.val){
            count = searchNode(val, cur.right);
        }else{
            count += cur.countGE;
            count += searchNode(val, cur.left);
        }

        return count;
    }
}

class BSTNode{
    long val;
    // number of child nodes whose val > this.val
    int countGE;
    BSTNode(int val){
        this.val = val;
        this.countGE = 1;
    }
    BSTNode left = null;
    BSTNode right = null;
}