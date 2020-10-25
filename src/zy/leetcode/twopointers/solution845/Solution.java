package zy.leetcode.twopointers.solution845;

public class Solution {
    public int longestMountain(int[] A) {
        int ans = 0;
        int p1 = 0, p2 = 1;
        while(p1 < A.length -2){
            while(p1<A.length -2 && A[p1] == A[p1+1]){
                p1++;
            }
            p2 = p1+1;
            if(isLeftValley(p1, A)){
                while(p2 < A.length){
                    if(A[p2] == A[p2-1]){
                        break;
                    }
                    if(isRightValley(p2, A)){
                        ans = Math.max(ans, p2 - p1 +1);
                        break;
                    }
                    p2++;
                }
            }
            p1 = p2;
        }

        return ans;
    }

    private boolean isLeftValley(int i, int[] A){
        if(i == 0) return A[0] < A[1];
        else return ( A[i-1] >= A[i] && A[i+1] > A[i]);
    }

    private boolean isRightValley(int i, int[] A){
        if(i==A.length-1) return  A[i-1] > A[i];
        else return ( A[i-1] > A[i] && A[i+1] >= A[i]);
    }
}

