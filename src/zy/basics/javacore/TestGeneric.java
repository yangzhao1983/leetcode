package zy.basics.javacore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by kaiser_zhao on 2018/12/31.
 */
public class TestGeneric {

    public static <T> T get(Supplier<T> s){
        Pair<Employee> pe = new Pair<>();
        Pair<Manager> pm = new Pair<>();
        List<Pair<Employee>> list = new ArrayList<>();
        list.add(pe);
        // list.add(pm); compile error

        List<Pair<? extends Employee>> elist = new ArrayList<>();
        elist.add(pm); // OK

        return s.get();
    }
}

class Pair<T>{

}

class Employee{

}

class Manager extends Employee{

}