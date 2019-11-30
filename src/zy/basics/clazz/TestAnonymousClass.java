package zy.basics.clazz;

/**
 * Created by kaiser_zhao on 2/23/18.
 */
public class TestAnonymousClass {

    // Can anonymous class have constructor? No!
    public void outerMethod2(){
        TestAnonymousClass tac =  new TestAnonymousClass(){
        };
    }

    // Can local class have constructor? Yes
    // Can local class have modifier public, private, protected? No!
    public void outerMethod1(){
        class LocalClass{
            public LocalClass(){

            }
        }
    }

    // Can inner class have constructor? Yes
    class InnerClass{
        public InnerClass(){

        }
    }
}
