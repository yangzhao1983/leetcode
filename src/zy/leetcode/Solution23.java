package zy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaiser_zhao on 2018/10/31.
 */
public class Solution23 {

    public static void main(String...strings){
        zy.leetcode.ListNode ln11 = new zy.leetcode.ListNode(1);
        zy.leetcode.ListNode ln12 = new zy.leetcode.ListNode(4);
        zy.leetcode.ListNode ln13 = new zy.leetcode.ListNode(5);
        ln11.next = ln12;
        ln12.next = ln13;

        zy.leetcode.ListNode ln21 = new zy.leetcode.ListNode(1);
        zy.leetcode.ListNode ln22 = new zy.leetcode.ListNode(3);
        zy.leetcode.ListNode ln23 = new zy.leetcode.ListNode(4);
        ln21.next = ln22;
        ln22.next = ln23;

        zy.leetcode.ListNode ln31 = new zy.leetcode.ListNode(2);
        zy.leetcode.ListNode ln32 = new zy.leetcode.ListNode(6);
        ln31.next = ln32;

        printListNode(mergeKLists(new zy.leetcode.ListNode[]{ln11, ln21, ln31}));
    }

    public static void printListNode(zy.leetcode.ListNode lns){

        while(lns!=null){
            System.out.println(lns.val);
            lns = lns.next;
        }
    }

    public static zy.leetcode.ListNode mergeKLists(zy.leetcode.ListNode[] lists){
        zy.leetcode.ListNode curNode = null;
        zy.leetcode.ListNode firstNode = null;
        int minNumber = Integer.MAX_VALUE;
        int minNodeNumber = 0;
        int emptyNumber = 0;
        Set<Integer> visited = new HashSet<Integer>();
        while(true){
            if (emptyNumber == lists.length){
                break;
            }
            int i = 0;
            for( ; i < lists.length; i++){
                if (visited.contains(i)){
                    continue;
                }

                if (lists[i] == null){
                    emptyNumber ++;
                    visited.add(i);
                    continue;
                }
                int curVal = lists[i].val;

                if (curVal < minNumber){
                    minNumber = curVal;
                    minNodeNumber = i;
                }
            }

            if(lists[minNodeNumber] !=null) {
                zy.leetcode.ListNode newLN = new zy.leetcode.ListNode(minNumber);
                if (curNode == null){
                    curNode = newLN;
                    firstNode = newLN;
                }else{
                    curNode.next = newLN;
                    curNode = newLN;
                }
                lists[minNodeNumber] = lists[minNodeNumber].next;
            }
            minNumber = Integer.MAX_VALUE;
        }
        return firstNode;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}


