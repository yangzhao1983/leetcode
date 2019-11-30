package zy.basics;

/**
 * Created by kaiser_zhao on 18/4/4.
 */
public class TestConsCallProtM {
    public static final void main(String...strings){
        new ChildClass();
    }
}

class ParentClass{
    public ParentClass(){
        subm();
    }

    protected void subm(){
        System.out.println("in parent");
    }
}
class ChildClass extends ParentClass{
    public ChildClass(){
        super();
        subm();
    }

    protected void subm(){
        System.out.println("in sub");
    }
}