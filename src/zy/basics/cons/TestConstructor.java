package zy.basics.cons;

/**
 * Created by kaiser_zhao on 2/22/18.
 */
public class TestConstructor {
    public static void main(String... strings){
    }
}

/**
 * A parent class without empty constructor
 *
 */
class A{
    public A(int param1){

    }
}

/**
 * A child class without empty constructor.
 */
class B extends A{
    public B(int param1){
        // Compile error without calling the parent constructor
        super(1);
    }
}

/**
 * A child class with empty constructor
 *
 */
class C extends A{
    public C(){
        // Compile error without calling the parent constructor
        super(1);
    }
}