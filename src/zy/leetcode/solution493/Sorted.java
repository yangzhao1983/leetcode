package zy.leetcode.solution493;

/**
 * Created by kaiser_zhao on 01/08/2019.
 */
public class Sorted {
    public static void main(String...strings){
        System.out.println(Integer.MAX_VALUE);
        int[] nums = {3,1};
        int sum = reversePairs(nums);
        System.out.println(sum);

        int[] nums2 = {1,3,2,3,1};
        sum = reversePairs(nums2);
        System.out.println(sum);

        int[] nums3 = {2,4,3,5,1};
        sum = reversePairs(nums3);
        System.out.println(sum);

        int[] nums4 = {7,4,3,5,1};
        sum = reversePairs(nums4);
        System.out.println(sum);

        int[] nums5 = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        sum = reversePairs(nums5);
        System.out.println(sum);

        int[] nums6 = {};
        sum = reversePairs(nums6);
        System.out.println(sum);
    }

    private static int reversePairs(int[] nums){
        int[] merged = new int[nums.length];
        int sum = merge_sort_and_count(nums, 0, nums.length -1 ,merged);
        return sum;
    }

    private static int merge_sort_and_count(int[] nums, int start, int end, int[] mergedNums){
        if(start> end){
            return 0;
        }

        int count = 0;

        if (start == end){
            mergedNums[0] = nums[start];
            return 0;
        }
        else{
            int mid = start + (end - start)/2;
            int[] numsL = new int[mid-start+1];
            int[] numsR = new int[end-mid];
            count += merge_sort_and_count(nums, start, mid, numsL);
            count += merge_sort_and_count(nums, mid+1, end, numsR);
            count += countLR(numsL,numsR);
            merge(numsL, numsR, mergedNums);
        }
        return count;
    }

    private static int countLR(int[] l, int[] r){
        int li = 0;
        int ri = 0;
        int count = 0;
        while(li < l.length && ri < r.length){
            long lli = Long.valueOf(l[li]);
            long lri = Long.valueOf(r[ri]);
            if(lli > lri * 2){
                count += l.length - li;
                ri ++;
            }else{
                li++;
            }
        }

        return count;
    }

    private static void merge(int[] l, int[] r, int[] mergedLR){

        int li = 0, ri = 0, i = 0;
        while(li < l.length && ri < r.length){
            mergedLR[i++] = l[li] > r[ri] ? r[ri++] : l[li++];
        }

        while(li < l.length){
            mergedLR[i++] = l[li++];
        }

        while(ri < r.length) {
            mergedLR[i++] = r[ri++];
        }
    }
}
