package zy.leetcode.complexity;

import java.util.Date;

/**
 * Created by kaiser_zhao on 2019/9/24.
 */
public class TestTimeComplexity {
    public static void main(String...strings){
        int million = 20000 * 20000;
        Date start = new Date();
        for(int i = 0 ; i < million ;i++){
            if(i%1000000==0){
                System.out.println(i);
            }
        }
        System.out.println((new Date().getTime()-start.getTime())/1000);
    }
}
