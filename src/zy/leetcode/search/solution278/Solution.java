package zy.leetcode.search.solution278;

public class Solution {
    public int firstBadVersion(int n) {
        return doBinarySearch(1, n);
    }

    private int doBinarySearch(int l, int r){
        int mid = l + (r - l)/2;
        if(isBadVersion(mid)){
            if(mid ==1 || !isBadVersion(mid-1)) return mid;
            return doBinarySearch(l, mid - 1);
        }else{
            if(isBadVersion(mid+1)) return mid + 1;
            return doBinarySearch(mid + 1, r);
        }
    }

    private boolean isBadVersion(int s){
        return true;
    }
}
