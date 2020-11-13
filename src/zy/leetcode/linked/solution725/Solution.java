package zy.leetcode.linked.solution725;

import org.junit.Assert;
import org.junit.Test;
import zy.leetcode.linked.ListNode;

import java.util.List;

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while(cur!=null){
            cur = cur.next;
            n++;
        }
        ListNode[] ans = new ListNode[k];
        if(n==0) return ans;
        int size = n/k, rem = n%k;

        cur = root;
        int i = 0;
        ListNode end = null;
        int j = 0;
        while(cur!=null){
            i = 0;
            ans[j] = cur;
            while(cur != null && i < size + (j < rem ? 1 : 0)){
                end = cur;
                cur = cur.next;
                i++;
            }
            if(cur == null) break;
            end.next = null;
            j++;
        }
        return ans;
    }
}
