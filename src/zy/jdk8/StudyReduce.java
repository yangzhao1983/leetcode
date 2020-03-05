package zy.jdk8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StudyReduce {
    public static void main(String...strings){
        testReduce1Empty();
        //testReduce1EmptyGet();
        testReduce1();
        testReduce1Get();
        testTransferSum();
        testTransferSumEmpty();
        testTwoParaSum();
        testTwoParaSumEmpty();
        testThreeParaSum();
        testThreeParaSumParallel();
        testThreeParaSumNonSense();
    }

    private static void testReduce1Empty(){
        List<Integer> list = new ArrayList<>();
        System.out.println(list.stream().reduce((a,b)->a+b)); // Optional.empty
    }

    private static void testReduce1EmptyGet(){
        List<Integer> list = new ArrayList<>();
        System.out.println(list.stream().reduce((a,b)->a+b).get());
        // Exception in thread "main" java.util.NoSuchElementException: No value present
        // https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
    }

    private static void testReduce1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.stream().reduce((a,b)->a+b)); // Optional[1]
    }

    private static void testReduce1Get(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.stream().reduce((a,b)->a+b).get()); // 1
    }

    private static void testTransferSum(){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        lists.add(list1);
        lists.add(list2);

        int rel = lists.stream().mapToInt(x->x.get(0)).sum();
        System.out.println(rel);
    }

    private static void testTransferSumEmpty(){
        List<List<Integer>> lists = new ArrayList<>();

        int rel = lists.stream().mapToInt(x->x.get(0)).sum();
        System.out.println(rel);
    }

    private static void testTwoParaSum(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int rel = list.stream().reduce(1,Integer::sum);
        System.out.println(rel);
    }

    private static void testTwoParaSumEmpty(){
        List<Integer> list = new ArrayList<>();
        int rel = list.stream().reduce(1,Integer::sum);
        System.out.println(rel);
    }

    private static void testThreeParaSum(){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        lists.add(list1);
        lists.add(list2);

        int rel = lists.stream().reduce(1, (a,b)->a + b.get(0), (x,y)->x+y);
        System.out.println(rel);
    }

    private static void testThreeParaSumParallel(){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        lists.add(list1);
        lists.add(list2);

        int rel = lists.parallelStream().reduce(1, (a,b)->a + b.get(0), (x,y)->x+y);
        System.out.println(rel);
    }

    private static void testThreeParaSumNonSense(){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        lists.add(list1);
        lists.add(list2);

        int rel = lists.stream().reduce(1, (a,b)->a + b.get(0), (x,y)->0);
        System.out.println(rel);
    }
}
