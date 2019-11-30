package zy.tijava.polymorphism;

/**
 * Created by kaiser_zhao on 07/04/2019.
 */
public class Exercise10 {
    public static void main(String...strings){
        A a = new B();
        a.m1();
    }
}

class A{
    public void m1(){
        System.out.println(this);
        m2();
    }
    public void m2(){
        System.out.println("A.m2()");
    }
}

class B extends A{
    public void m2(){
        System.out.println("B.m2()");
    }
}
