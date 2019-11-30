package zy.tijava.polymorphism;

/**
 * Created by kaiser_zhao on 2019/11/13.
 */
public class TestInh {
    public static void main(String...strings){
//        m1(1);
        m1(Integer.valueOf(1));
    }
    private static void m1(long l){
        System.out.println("long");
    }
//    private static void m1(int i){
//        System.out.println("int");
//    }
//    private static void m1(Object o){
//        System.out.println("Object");
//    }
    private static void m1(Long lo){
        System.out.println("Long");
    }
//    private static void m1(Integer io){
//        System.out.println("Integer");
//    }
}
