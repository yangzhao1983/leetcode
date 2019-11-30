package zy.basics.sort;

/**
 * Created by kaiser_zhao on 3/21/18.
 */
public class BubleSort{
    public static final void main(String...strings){
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

        for(int i = 0; i<items.length-1;i++){
            for(int j = i+1; j<items.length; j++){
                if(items[i] > items[j]){
                    swap(i, j, items);
                }
            }
        }

        for(int i=0; i<9; i++){
            System.out.println(items[i]);
        }
    }
    private static void swap(int source, int target, int[] items){
        if(source == target){
            return;
        }

        int tmp = items[source];
        items[source] = items[target];
        items[target] = tmp;
    }
}
