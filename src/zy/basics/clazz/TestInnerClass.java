package zy.basics.clazz;

/**
 * Created by kaiser_zhao on 2/22/18.
 */
public class TestInnerClass {
    public static void main(String... strings){
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
    }
}
