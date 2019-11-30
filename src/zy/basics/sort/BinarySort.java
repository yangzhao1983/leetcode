package zy.basics.sort;

/**
 * Created by kaiser_zhao on 3/21/18.
 */
public class BinarySort {
    public static void main(String...strings){
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

        for(int i = 1; i<items.length; i++){
            int pos = getReplaceIndex(0, i-1, i, items);
            if(items[pos]<items[i]){
                int temp = items[i];
                for(int j = i;j>pos+1 ;j--){
                    items[j] = items[j-1];
                }
                items[i] = temp;
            }else{
                int temp = items[i];
                for(int j = i;j>pos ;j--){
                    System.out.println(j);
                    items[j] = items[j-1];
                }
                items[pos] = temp;
            }
        }
        System.out.println("===========");
        for(int i=0; i<9; i++){
            System.out.println(items[i]);
        }
    }

    private static int getReplaceIndex(int rangeS, int rangeE, int get, int[] items){
        if(rangeE == rangeS){
            return rangeE;
        }

        int mid = (rangeE + rangeS)/2;

        if(items[mid] > items[get]){
            return getReplaceIndex(rangeS, mid, get, items);
        }else{
            return getReplaceIndex(mid+1, rangeE, get, items);
        }
    }

    private static void printItems(int[] items){
        for(int i : items){
            System.out.println(i);
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
