package zy.basics.javacore;

/**
 * Created by kaiser_zhao on 2018/12/29.
 */
public class TestInnerClass {
    private String outerStr;
    private int var = 1;
    public static void main(String...strings){
        TestInnerClass tic = new TestInnerClass();
        tic.outputInnerClass();
        TestInnerClass tic2 = new TestInnerClass();
        tic2.outputInnerClass();
    }

    public TestInnerClass(){
        outerStr = "";
    }

    private void outputInnerClass(){
        InnerClass ic = new InnerClass();
        System.out.println(ic.getClass().getName());
    }

    public class InnerClass{
        public String interClassStr = "inter class string";
        private void outputOuterFiled(){
            System.out.print(outerStr);
            var++;
        }
    }
}
