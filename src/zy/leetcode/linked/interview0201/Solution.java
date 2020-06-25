package zy.leetcode.linked.interview0201;

import zy.leetcode.linked.ListNode;

import java.util.HashSet;

import java.util.Set;

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null){
            return null;
        }
        Set<Integer> visited = new HashSet<>();
        ListNode node = head;
        visited.add(node.val);
        while(node.next!=null){
            ListNode next = node.next;
            if(visited.contains(next.val)){
                node.next = next.next;
            }else{
                visited.add(next.val);
                node = node.next;
            }
        }
        return head;
    }
}
