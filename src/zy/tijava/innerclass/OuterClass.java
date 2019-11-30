package zy.tijava.innerclass;

/**
 * Created by kaiser_zhao on 08/04/2019.
 */
public class OuterClass {
    public void accessInterPrivate(){
        InnerClass ic = new InnerClass();
        ic.innerField.length();
    }

    private class InnerClass{
        private String innerField = "";
    }
}
