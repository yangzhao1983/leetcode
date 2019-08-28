package zy.leetcode.mysort;

/**
 * Created by kaiser_zhao on 2019/8/26.
 */
public class MyPivot {

    public static void main(String...strings){
        testcase1();
        testcase2();
        testcase3();
        testcase4();
        testcase5();
        testcase6();
    }

    private static void testcase1(){
        int[] nums = {1,2,3,4};
        pivotSort(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void testcase2(){
        int[] nums = {4,3,2,1};
        pivotSort(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void testcase3(){
        int[] nums = {};
        pivotSort(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void testcase4(){
        int[] nums = null;
        pivotSort(nums);
    }

    private static void testcase5(){
        int[] nums = {5,1};
        pivotSort(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void testcase6(){
        int[] nums = {5,1,6};
        pivotSort(nums);
        for(int i : nums){
            System.out.println(i);
        }
    }

    private static void pivotSort(int[] nums){
        if(nums==null || nums.length <=1){
            return;
        }
        doPivotSort(nums, 0, nums.length-1);
    }

    private static void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    private static void doPivotSort(int[] nums, int left, int right){

        // left = right, only one item, no need to swap
        // left > right, no need to swap
        if(left >= right){
            return;
        }

        // only two items
        if(right - left == 1){
            if(nums[left] > nums[right]){
                swap(nums, left, right);
            }
            return;
        }

        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while(i<j){
            while(i <j && nums[i] < pivot){
                i++;
            }
            while(j >i && nums[j] > pivot){
                j--;
            }
            //
            if(i==j) break;
            swap(nums, i, j);
        }

        // swap pivot with the pos
        int pos = -1;
        if(nums[i]>pivot){
            pos = i-1;
        }else{
            pos = i;
        }

        if (pos!=left) swap(nums, left, pos);

        // recurse left part
        doPivotSort(nums, left, pos-1);
        // recurse right part
        doPivotSort(nums, pos+1, right);
    }
}
