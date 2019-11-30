package zy.basics.control;

/**
 * Created by kaiser_zhao on 2/22/18.
 */
public class TestLabelFor {
    public static void main(String... strings){
        search: for(int i = 0; i<10; i++){
            for(int j= 0; j < 10; j++){
                if(i== 2 && j == 3){
                    break search;
                }
            }
        }
    }

    
}
