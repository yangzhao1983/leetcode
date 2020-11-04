package zy.leetcode.sortandsearch.solution715;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RangeModule {

    private List<Pair<Integer, Integer>> list;
    public RangeModule() {
        list = new ArrayList<>();
    }

    public void addRange(int left, int right) {
        List<Pair<Integer, Integer>> tmp = new ArrayList<>();
        boolean inserted = false;
        for(Pair<Integer, Integer> pair : list){
            int curL = pair.getKey();
            int curR = pair.getValue();
            if(curL > right){
                if(!inserted){
                    tmp.add(new Pair<>(left ,right));
                    inserted = true;
                }
                tmp.add(pair);
            }else if(curR < left){
                tmp.add(pair);
            }else{
                left = Math.min(left, curL);
                right = Math.max(right, curR);
            }
        }
        if(!inserted)tmp.add(new Pair<>(left ,right));
        list = tmp;
    }

    public boolean queryRange(int left, int right) {
        for(Pair<Integer, Integer> pair : list){
            int curL = pair.getKey();
            int curR = pair.getValue();
            if(curL <= left && curR >= right){
                return true;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        List<Pair<Integer, Integer>> tmp = new ArrayList<>();
        for(Pair<Integer, Integer> pair : list){
            int curL = pair.getKey();
            int curR = pair.getValue();
            if(curL <= left && curR >= right){
                if(left > curL) tmp.add(new Pair<>(curL, left));
                if(curR > right) tmp.add(new Pair<>(right, curR));
            } else if(curL >= left && curR <= right){
                continue;
            } else if(curL <= left && curR >= left){
                tmp.add(new Pair<>(curL, left));
            }else if(curL <= right && curR >= right){
                tmp.add(new Pair<>(right, curR));
            } else{
                tmp.add(pair);
            }
        }
        list = tmp;
    }

    @Test
    public void test1(){
        RangeModule rm = new RangeModule();
        rm.addRange(10,20);
        rm.removeRange(14,16);
        Assert.assertEquals(true, rm.queryRange(10,14));
        Assert.assertEquals(false, rm.queryRange(13,15));
        Assert.assertEquals(true, rm.queryRange(16,17));

        System.out.println();
    }

    @Test
    public void test2(){
        RangeModule rm = new RangeModule();
        rm.addRange(5,6);
        rm.addRange(2,8);
        Assert.assertEquals(false, rm.queryRange(1,4));
        rm.removeRange(2,4);
        Assert.assertEquals(true, rm.queryRange(4,5));

        System.out.println();
    }
}
