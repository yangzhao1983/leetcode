package zy.leetcode.search.solution374;

public class Solution {
    public int guessNumber(int n) {
        return doBinarySearch(1, n);
    }

    private int doBinarySearch(int l, int r){
        int mid = l + (r - l)/2;
        if(guess(mid) == 0){
            return mid;
        }else if( guess(mid) == -1){
            return doBinarySearch(l, mid - 1);
        }else{
            return doBinarySearch(mid+1, r);
        }
    }

    private int guess(int num){
        return 0;
    }
}
