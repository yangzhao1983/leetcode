package zy.basics.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 3/21/18.
 */
public class ListSum {
    public static final void main(String...strings){
        List<Integer> list = new ArrayList<Integer>();
        int target = 10;
        for(int i = 0; i<10; i++){
            list.add(i);
        }

        for(int i = 0; i<10; i++){
            for(int j=i+1; j<10; j++){
                int sum = list.get(i) + list.get(j);
                if(sum == target){
                    System.out.println( i + "+" + j + "=" + target);
                }
            }

        }
    }
}
