package zy.leetcode.array.solution4;

public class Solution {
    /**
     * assuming a[m], b[n], m<=n
     * for 0<i<m, a[m] can be divided to a[0]...a[i-1] | a[i],a[i+1],...a[m] => left_a, right_a
     * for 0<j<m, a[n] can be divided to b[0]...b[j-1] | b[j],b[j+1],...b[n] => left_b, right_b
     *
     *
     * Should satisfy:
     * 1. i + j = (m + n + 1)/2 =>
     *
     * len_total is even, len(left_a, left_b) == len(right_a, right_b)
     * len_total is odd, len(left_a, left_b) == len(right_a, right_b) + 1
     *
     * 2. a[i-1] <= b[j] && b[j-1] <= a[i]
     *
     * if len_total is even, then median =( max(a[i-1], b[j-1]) + min(a[i], b[j]))/2
     * if len_total is odd, then median = max(a[i-1], b[j-1])
     *
     *
     *
     * if a[i] < b[j-1], then a[i-1] must < [bj], so we can only focus on a[i] and b[j-1].
     * i = (iMin + iMax)/2, iMin = i + 1, iMax = iMax
     *
     * if a[i-1] > b[j]
     * i = (iMin + iMax)/2, iMin = iMin, iMax = i - 1
     *
     * initial i: m/2 + 1
     *
     * if i==m, i == 0, j==0, j==n get it!
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = null;
        int[] b = null;
        if(nums1.length > nums2.length){
            b = nums1;
            a = nums2;
        }else{
            a = nums1;
            b = nums2;
        }

        int m = a.length;
        int n = b.length;

        int iMin = 0;
        int iMax = m;
        while(iMin <= iMax){
            int maxLeft = 0;
            int i = (iMin + iMax)/2;
            int j = (m+n+1)/2 - i;
            if (i < iMax && b[j-1] > a[i]){
                iMin = i + 1;
            }
            else if (i > iMin && a[i-1] > b[j]) {
                iMax = i - 1;
            }else{
                if(i==0){
                    maxLeft = b[j-1];
                }else if (j==0){
                    maxLeft = a[i-1];
                }else{
                    maxLeft = Math.max(a[i-1], b[j-1]);
                }
                if((m+n)%2==1){
                    return maxLeft;
                }
                int minRight = 0;
                if(i==m){
                    minRight = b[j];
                }else if (j==n){
                    minRight = a[i];
                }else{
                    minRight = Math.min(a[i],b[j]);
                }
                return (minRight + maxLeft)/2.0;
            }
        }
        return 0;
    }

    private static void test1(){
        Solution sol = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 ={2};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }

    private static void test2(){
        Solution sol = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 ={3,4};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }

    public static void main(String...strings){
//        test1();
        test2();
    }
}
