package zy.basics.sort;

/**
 * Created by kaiser_zhao on 3/20/18.
 */
public class QuickSort {

    public static final void main(String... strings){
        int[] items = new int[9];
        items[0] = 3;
        items[1] = 2;
        items[2] = 1;
        items[3] = 6;
        items[4] = 19;
        items[5] = 12;
        items[6] = 11;
        items[7] = 12;
        items[8] = 10;


//        for(int i = 0; i<3; i++){
//            items[i] = (int)(Math.random() * 3);
//        }
        sort(0, 8, items);
        for(int i=0; i<9; i++){
            System.out.println(items[i]);
        }
    }

    private static void sort(int start, int end, int items[]){

        if(end <= start){
            return;
        }

        // i = start
        int leftExpectLargerEqual = start+1;
        // j = end
        int rightExpectedLess = end;

        // get the pos for swap
        // 1. search from left, if it is smaller or equal to start, move right
        // 2. search from right, if it is bigger, move left
        while (leftExpectLargerEqual < rightExpectedLess) {
            while (items[leftExpectLargerEqual] < items[start] && leftExpectLargerEqual< rightExpectedLess) {
                leftExpectLargerEqual++;
            }

            while (items[rightExpectedLess] > items[start] && leftExpectLargerEqual < rightExpectedLess) {
                rightExpectedLess--;
            }


            // swap
            swap(leftExpectLargerEqual, rightExpectedLess, items);
        }
        int aix = 0;
        if(items[leftExpectLargerEqual]>=items[start]){
            aix = leftExpectLargerEqual-1;
        }else{
            aix = leftExpectLargerEqual;
        }

        // swap items[start] and items[j]
        swap(start, aix, items);


        // sort(start, j), sort(i, end)
        sort(start, aix- 1, items);

        sort(aix+1, end, items);

    }

    private static void swap(int source, int target, int items[]){
        if(source >= target){
            return;
        }

        if(target >=items.length){
            return;
        }
        int tmp = items[source];
        items[source] = items[target];
        items[target] = tmp;
    }
}
