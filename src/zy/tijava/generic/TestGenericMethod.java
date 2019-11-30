package zy.tijava.generic;

/**
 * Created by kaiser_zhao on 05/08/2019.
 */
public class TestGenericMethod {

    public static void main(String...strings){
        Parent c = new Child();
        c.setSecond("");
    }

}
class Parent{
    public void setSecond(Object second){
        System.out.println("setSecond in parent");
    }
}

class Child extends Parent{
    public void setSecond(String second){
        System.out.println("setSecond in Child");
    }
}
