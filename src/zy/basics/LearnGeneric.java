package zy.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaiser_zhao on 18/6/7.
 */
public class LearnGeneric {
    public static final void main(String... strings){
        List<?> unknownList = new ArrayList<>();
        List<? extends Parent> unknownNumberList = new ArrayList<>();
    }
}

class Parent{}

class Child extends Parent{}
