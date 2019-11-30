package zy.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 18/4/4.
 */
public class TestRef {
    public static void main(String...strings){
        RefObject rb1 = new RefObject("value1");
        List<RefObject> list = new ArrayList<RefObject>();
        list.add(rb1);
        System.out.print(list.get(0).getValue());
        rb1 = new RefObject("value2");
        System.out.print(list.get(0).getValue());
    }
}

class RefObject{

    private String value;
    public RefObject(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

