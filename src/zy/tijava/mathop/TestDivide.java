package zy.tijava.mathop;

public class TestDivide {
    private static void test1(){
        System.out.println(9/4);
        System.out.println(9/-4);
        System.out.println(-9/4);
        System.out.println(-9/-4);
        System.out.println(4/9);
        System.out.println(-4/9);
        System.out.println(4/-9);
        System.out.println(-4/-9);
        System.out.println(Integer.MIN_VALUE/-1);
    }

    private static void test2(){
        System.out.println(9%4);
        System.out.println(9%-4);
        System.out.println(-9%4);
        System.out.println(-9%-4);

        System.out.println(4%9);
        System.out.println(-4%9);
        System.out.println(4%-9);
        System.out.println(-4%-9);
        System.out.println(Integer.MIN_VALUE%-1);
    }

    private static void test3(){

    }

    private static void test4(){
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
    }
}
