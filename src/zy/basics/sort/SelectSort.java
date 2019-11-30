package zy.basics.sort;

/**
 * Created by kaiser_zhao on 3/21/18.
 */
public class SelectSort {

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

        int min = 0;
        for(int i = 0; i<items.length-1; i++){
            min = i;
            for(int j = i; j<items.length; j++){
                if(items[j]<items[min]){
                    min = j;
                }
            }
            swap(i, min, items);
        }

        for(int i=0; i<9; i++){
            System.out.println(items[i]);
        }
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
