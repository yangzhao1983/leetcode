package zy.leetcode.array.solution849;

/**
 * Created by kaiser_zhao on 2019/10/18.
 */
public class LeftRight {

    public static void main(String...strings){
        testcase1();
        testcase2();
    }

    private static void testcase1(){
        int[] nums = {1,0,0,0,1,0,1};

        System.out.println(maxDistToClosest(nums));
    }

    private static void testcase2(){
        int[] nums = {1,0,0,0};

        System.out.println(maxDistToClosest(nums));
    }

    public static int maxDistToClosest(int[] seats) {
        int[] left = new int[seats.length];

        if(seats[0]==0){
            left[0] = 1;
        }

        for(int i = 1; i < seats.length; i++){
            if(seats[i] == 1){
                left[i] = 0;
            }else{
                left[i] = left[i-1] +1 ;
            }
        }

        int[] right = new int[seats.length];

        if(seats[seats.length-1]==0){
            right[seats.length-1] = 1;
        }

        for(int i = seats.length-2; i >= 0; i--){
            if(seats[i] == 1){
                right[i] = 0;
            }else{
                right[i] = right[i+1] +1 ;
            }
        }

        int max = 0;

        int first = sort(left[0],right[0],false);
        if(first>max){
            max = first;
        }

        int last = sort(left[seats.length-1],right[seats.length-1],false);
        if(last>max){
            max = last;
        }

        for(int i = 1; i <seats.length-1; i++){
            int length = sort(left[i], right[i],true);
            if(length > max){
                max = length;
            }
        }

        return max;
    }

    private static int sort(int left, int right, boolean min){
        if(min){
            return left > right ? right : left;
        }else{
            return left < right ? right : left;
        }
    }
}
