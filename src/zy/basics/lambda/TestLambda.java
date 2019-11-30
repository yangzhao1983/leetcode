package zy.basics.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 2/23/18.
 */
public class TestLambda {
    private static List<Integer> list = new ArrayList<Integer>();

    // this is also valid
    //private static List list = new ArrayList<Integer>();

    public static void main(String... strings){
        list.add(1);
        list.add(2);
        int plus = 1;
        list.stream().forEach(elem ->{
            //they do not inherit any names from a supertype or introduce a new level of scoping.
            // Declarations in a lambda expression are interpreted just as they are in the enclosing environment.
            //int plus = 2;
            int result = elem + plus;
            System.out.println(result);
        } );
    }
}
