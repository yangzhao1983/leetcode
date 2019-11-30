package zy.basics.generictype;

/**
 * Created by kaiser_zhao on 2/23/18.
 */
public class TestGeneric<F> {

    // This can work since <T> has been declared in method definition
    <T> void doSomeThing(T t){

    }

    //This can work since <F> has been declared in Class definition.
    F doSomeOtherThing(){
        F f = null;
        return f;
    }

    public static void main(String...strings){

    }
}
