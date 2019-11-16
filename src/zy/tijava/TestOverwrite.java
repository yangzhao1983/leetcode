package zy.tijava;

/**
 * Created by kaiser_zhao on 30/03/2019.
 */
public class TestOverwrite {
    public static void main(String...strings){
        f(1, 'c');
        Character[] cs = {'c','a'};
//        f('c','a');
        f('c');
        f(1);
    }

//    private static void f(float f, Character...cs){
//        System.out.println("f = " + f);
//        for(Character c : cs){
//            System.out.println("c = " + c);
//        }
//    }
//
//    private static void f(Character...cs){
//        for(Character c : cs){
//            System.out.println("c = " + c);
//        }
//    }

    /**
     * different return type TODO: no
     */
//    private static int f(float f, Character...cs){
//        System.out.println("f = " + f);
//        for(Character c : cs){
//            System.out.println("c = " + c);
//        }
//        return 1;
//    }

    /**
     * different modifier TODO: no
     *
     * @param f
     * @param cs
     */
//    private void f(float f, Character...cs){
//        System.out.println("f = " + f);
//        for(Character c : cs){
//            System.out.println("c = " + c);
//        }
//    }

//    private static void f(Character c, float f){
//        System.out.println("f = " + f);
//        System.out.println("c = " + c);
//    }

    /**
     * different sequence makes over write
     *
     * @param f
     * @param c
//     */
//    private static void f(float f, Character c){
//        System.out.println("f = " + f);
//        System.out.println("c = " + c);
//    }

    private static void f(float f, Character c){
        System.out.println("int f = " + f);
        System.out.println("c = " + c);
    }

    private static void f(Character f, Character c){
        System.out.println("f = " + f);
        System.out.println("c = " + c);
    }

    private static void f(char f, Character c){
        System.out.println("f = " + f);
        System.out.println("c = " + c);
    }

    private static void f(Character f){
        System.out.println("character f = " + f);
    }

//    private static void f(char f){
//        System.out.println("char f = " + f);
//    }
//
//    private static void f(int f){
//        System.out.println("char f = " + f);
//    }

    private static void f(float f){
        System.out.println("char f = " + f);
    }
}
