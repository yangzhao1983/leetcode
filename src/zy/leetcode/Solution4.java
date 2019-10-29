package zy.leetcode;

/**
 * Created by kaiser_zhao on 27/09/2018.
 */
public class Solution4 {

    public static double findMedianSortedArrays5(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    /**
     * M, N, lm<=ln
     *
     * Initial: start = 0, end=ln-1, isEven = (ln+lm)%2==0
     * loop start<=end
     * curM = (start+end)/2 + 1,
     * curN = (ln+lm+1)/2 - curM
     *
     * if curM==lm or curN==0 or N[curN-1]<=M[curM] got it
     * if curN==ln or curM == 0 M[curM-1] <= N[curN]
     *
     * if N[curN]<M[curM-1], end=curM-1
     * if N[curN-1]>M[curM], start=curM+1
     *
     * if curM==0, min(M)>=max(N)
     * if curM==lm, min(N)>=max(M)
     * if curN=0, min(N)>=max(M)
     * if curN=ln, min(M)>max(N)
     *
     *
     * if !isEven
     * return max(N[curN-1],  M[curM-1])
     * else
     * return max(N[curN-1],  M[curM-1]) + min(N[curN],  M[curM])
     *
     * M[0],M[1],...M[cur1],M[cur1+1],..M[l1-1]
     * N[0],N[1],...N[cur2],N[cur2+1],..N[l2-1]
     */
    private static double findMedianSortedArrays4(int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int start = 0;
        int end = l1;
        boolean isEven = (l1+l2)%2==0;
        int cur1 = 0;
        int cur2 =0;
        while(start <= end){
            cur1 = (start+end)/2;
            cur2 = (l1+l2 + 1)/2 - cur1;

            if ( cur1 > start && nums2[cur2]<nums1[cur1-1]){
                end = cur1 - 1;
                continue;
            }

            if( cur1 < end && nums2[cur2-1]>nums1[cur1]){
                start = cur1 + 1;
                continue;
            }

            int maxLeft = 0;
            int minRight = 0;
            if (cur1 == 0){
                // start = cur1 = 0 last time nums2[cur2]<nums1[cur1-1]
                maxLeft = nums2[cur2-1];
            }else if (cur2==0){
                maxLeft = nums1[cur1-1];
            }else{
                maxLeft = Math.max(nums1[cur1-1], nums2[cur2-1]);
            }

            if(!isEven) return maxLeft;

            if (cur2==l2){
                minRight = nums1[cur1];
            }else if (cur1 == l1){
                // end = cur1 = l1 last time nums2[cur2-1] > nums1[cur1]
                minRight = nums2[cur2];
            }
            else{
                minRight = Math.min(nums1[cur1], nums2[cur2]);
            }

            if(isEven) return (maxLeft + minRight)/2.0;
        }
        return -1;
    }

    public final static void main(String... strings){
        int[] nums1 ={};
        int[] nums2 = {1};
        System.out.println(findMedianSortedArrays4(nums1,nums2));
    }

    /**
     * M, N, lm>=ln
     * Select M[m], 0<=m<lm, all = 0
     * curM = 0
     *
     * bi-search N, search n N[n]=<M[curM]<=N[n+1]
     * 1. start = 0, end = ln-1
     * loop
     *  curN = (start+end)/2,
     *  if N[curN]<=M[curM]<=N[n+1], all = all + 1 + (curN-start)
     * select [0, ln) from N, , all=all+(n-start) + 1, then m++, start from [n+1 to ln),
     *
     *
     *
     */

    /**
     * M[lm], N[ln]
     *
     * Given i and j, 0<=i<lm, 0<=j<ln. i+j = (Mend-Mstart+Nend-Nstart)/2 - 2, Mstart=0, Mend=lm-1, Nstart=0, Nend=ln-1
     * 1. select one item from M, i = (lm-1)/2
     * 2. get the twin in N, N[j]
     * 3. Compare M[i] and N[j]
     *  a. If N[j]<=M[i]<=N[j+1]
     *      a.1 if even, median = (N[j] + M[i])/2
     *      a.2 else odd, median = M[i]
     *  b. If M[i]<=N[j]<=M[i+1]
     *      b.1 if even, median = (N[j] + M[i])/2
     *      b.2 else odd, median = N[j]
     *  c. If M[i] < N[j], means median is in M(i, Mend], or in N[Nstart, j)  get Mtwin, get Ntwin, if Ntwin < 0, get Ntwin, get Mtwin
     *  d. If M[i] > N[j], means median is in M[Mstart, i), or in N(j, Nend], get Mtwin, get Ntwin, if Ntwin > lm-1, get Ntwin, get Mtwin
     */

    /**
     * M[lm], N[ln] assume lm=ln
     *
     * Median: k, (ln+lm)/2 items whose value are not greater then k, and (ln+lm)/2 items whose value are not less than k
     *
     * Assume M[m] = k, in M, there m items whose value are not greater then k. Then
     *
     * Get "twin" of m, n, m+n=(lm+ln+1)/2
     *
     * check if there are n items whose value are not greater than k: means
     *  if N[n] <= k <=N[n+1] Then GOT it
     *
     * If N[n] > k, there are less items whose value are not greater than k,
     * ====>should look for k in [m+1, lm)
     *
     *
     */

    private static double getMedian(int nums[]){
        int len = nums.length;
        return len%2==0 ? (nums[(len-1)/2]+nums[(len-1)/2+1])/2:nums[len/2];
    }

    public static double findMedianSortedArrays3Out(int[] nums1, int[] nums2) {
        // if nums1 is empty. Get median of nums2.
        // if nums2 is empty. Get median of nuns1.
        // need to consider one array is empty
        if(nums1.length == 0){
            return getMedian(nums2);
        }

        if(nums2.length == 0){
            return getMedian(nums1);
        }

        // if nums1.length > nums2.length pass nums1.length as the first parameter; else
        //  pass nums2.length as the first paramter
        return nums1.length>nums2.length? findMedianSortedArrays3(nums2, nums1):findMedianSortedArrays3(nums1, nums2);
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {

        int lm = nums1.length;
        int ln = nums2.length;

        int start = 0;
        int end = lm -1;

        int median = 0;

        boolean hasEven = (lm+ln)%2 == 0;

        while(end >=start){
            int mid = (end-start)/2 + start;
            int k = nums1[mid];

            int twin = (ln+lm+1)/2 - 2 - mid;

            if((nums2[twin] <= k) && (k <= nums2[twin+1])){
                int k2 = Math.min(nums1[mid+1], nums2[twin+1]);
                return hasEven? (k+k2)/2 : k2;
            } if(nums2[twin]>=k && nums2[twin]<=nums1[mid+1]){
                int k2 = Math.max(nums2[twin], k);
            }
            else{
                if (nums2[twin] > k){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }

        System.out.println(start);

//        if(start == lm){
//            int midInx = (ln-lm)/2 - 1;
//            return hasEven? (nums2[midInx] + nums2[midInx+1])/2:nums2[midInx+1];
//        }else{
//            int midInx = (ln+lm)/2 -1;
//            return hasEven? (nums1[midInx] + nums1[midInx+1])/2:nums1[midInx+1];
//        }

        return -1;
    }

    private static int getOneTwin(int start, int end){
        return (end+1-start)/2;
    }

    private static int getAnotherTwin(int twinM, int startM, int endM, int startN, int endN){
        return ((endM + endN - startM - startN)/2 -2);
    }

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * You may assume nums1 and nums2 cannot be both empty.
     *
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] ans = new int[(nums1.length + nums2.length)/2 + 1] ;

        boolean isEvenNum = (nums1.length + nums2.length) % 2 ==0;
        int i = 0, j=0, k=0;
        for(; i< nums1.length && j<nums2.length && k<ans.length;){
            boolean popNums1 = getMin(nums1, nums2, i, j);
            ans[k] = popNums1? nums1[i++] : nums2[j++];
            k++;
        }
        if(i<nums1.length){
            for(int n = 0; n+k<ans.length; n++){
                ans[n+k] = nums1[i+n];
            }
        }

        if(j<nums2.length){
            for(int n = 0; n+k<ans.length; n++){
                ans[n+k] = nums2[j+n];
            }
        }

        for(int item : ans){
            System.out.print(item);
            System.out.print(" ");
        }
        return isEvenNum? (ans[ans.length-1] + ans[ans.length-2])*1.0/2 : ans[ans.length-1];
    }

    private static boolean getMin(int[] nums1, int[] nums2, int index1, int index2){
        if(nums1[index1] < nums2[index2]){
            return true;
        }else{
            return false;
        }
    }
}
