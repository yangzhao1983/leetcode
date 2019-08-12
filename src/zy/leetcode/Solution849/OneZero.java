package zy.leetcode.Solution849;

/**
 * Created by kaiser_zhao on 12/08/2019.
 */
public class OneZero {
    public static void main(String...strings){
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));

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
        boolean start = true;
        boolean findZero = false;
        int zeroStart = 0;
        int len = 0;
        for(int i = 0; i < seats.length; i++){
            if(start){
                // search 1 from start, here there is no 1 in the left.
                if(seats[i]==1){
                    start = false;
                    len = i;
                    findZero = true;
                }
            }else{
                if(findZero){
                    if(seats[i] == 0){
                        zeroStart = i;
                        findZero = false;
                    }
                }else{
                    if(seats[i]==1){
                        int curLen = (i-zeroStart+1)/2;
                        if(curLen>len){
                            len = curLen;
                        }
                        findZero = true;
                    }
                }
            }
        }

        // there is no 1
        if(start){
            len = seats.length;
        }

        if(!findZero){
            int curLen = seats.length - zeroStart;
            if(curLen>len){
                len = curLen;
            }
        }
        return len;
    }
}
