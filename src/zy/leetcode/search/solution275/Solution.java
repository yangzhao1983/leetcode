package zy.leetcode.search.solution275;

public class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length == 0) return 0;
        return doBinarySearch(citations, 0, citations.length-1);
    }

    private int doBinarySearch(int[] citations, int l, int r){
        if(l > r) return l;
        int mid = l + (r-l)/2;
        int n = citations.length;
        if(citations[n - 1 - mid] > mid){
            if(mid == n-1) return mid+1;
            if(citations[n-1-mid-1] <= mid +1){
                return mid+1;
            }else{
                l = mid + 1;
                return doBinarySearch(citations, l, r);
            }
        }else{
            r = mid - 1;
            return doBinarySearch(citations, l, r);
        }
    }
}
