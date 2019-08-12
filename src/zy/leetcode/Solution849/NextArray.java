package zy.leetcode.Solution849;

import java.util.Arrays;

/**
 * Created by kaiser_zhao on 12/08/2019.
 */

public class NextArray {
    public static void main(String...strings){
//        int[] seats = {1,0,0,0,1,0,1};
//        System.out.println(maxDistToClosest(seats));

        int[] seats1 = {0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats1));

        int[] seats2 = {0,1,0,0};
        System.out.println(maxDistToClosest(seats2));

        int[] seats3 = {0};
        System.out.println(maxDistToClosest(seats3));

        int[] seats4 = {1,1,1};
        System.out.println(maxDistToClosest(seats4));
    }

    public static int maxDistToClosest(int[] seats) {

        int N = seats.length;
        int[] left = new int[N];
        int[] right = new int[N];

        Arrays.fill(left, N);
        Arrays.fill(right, N);

        // find left array
        for(int i = 0 ; i<N; i++){
            if(seats[i]==1){
                left[i] = 0;
            }else if(i>0){
                left[i] = left[i-1] + 1;
            }
        }


        // find right array
        for(int i = N-1 ; i>=0; i--){
            if(seats[i]==1){
                right[i] = 0;
            }else if(i<N-1){
                right[i] = right[i+1] + 1;
            }
        }

        // min(left[i], right[i])
        int ans = 0;
        for(int i = 0; i< N; i++){
            if(seats[i] == 0){
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;
    }
}
