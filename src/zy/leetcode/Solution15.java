package zy.leetcode;

import java.util.*;

/**
 * Created by kaiser_zhao on 2018/10/20.
 */
public class Solution15 {
    public static void main(String...strings){
//        System.out.println(threeSum2(new int[] {-1, 0, 1, 2,}));
//        System.out.println(threeSum2(new int[] {-1, 0, 1, 2, -1, -4}));
       // System.out.println(threeSum3(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
//        System.out.println(threeSum2(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
//        System.out.println(threeSum4(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
//        System.out.println(threeSum4(new int[] {1,2,-2,-1}));
//        System.out.println(threeSum4(new int[] {3,0,-2,-1,1,2}));
//        System.out.println(threeSum4(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        System.out.println(threeSum5(new int[] {0,0,0,1}));
    }

    public static List<List<Integer>> threeSum5(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> rels = new ArrayList<List<Integer>>();
        if(nums.length <3){
            return new ArrayList<List<Integer>>();
        }

        // put all of the numbers to tree map item->number
        // 1. if key=0, number =3, return [0,0,0]
        // 2. Map[i:], for key<0, if exist key1=0, key2=-key, store
        // 3. Map[i:], for key<0, value =2, if exit key1=-2* key, store
        // 4. Map[i:]
        Map<Integer, Integer> store = new TreeMap<Integer, Integer>();
        for(Integer num:nums){
            if(store.containsKey(num)){
                store.put(num,store.get(num)+1);
            }else{
                store.put(num, 1);
            }
        }

        if(store.containsKey(0)){
            if(store.get(0)>=3){
                List<Integer> rel = new ArrayList<>();
                rel.add(0);
                rel.add(0);
                rel.add(0);
                rels.add(rel);
            }
            for(Integer num : store.keySet()){
                if(num<0 && store.containsKey(-1*num)){
                    List<Integer> rel = new ArrayList<>();
                    rel.add(num);
                    rel.add(0);
                    rel.add(-1 * num);
                    rels.add(rel);
                }
            }
        }

        store.remove(0);

        for(Integer num : store.keySet()){
            if(store.get(num) >=2 && store.containsKey(num * -2)){
                List<Integer> rel = new ArrayList<>();
                rel.add(num);
                rel.add(num);
                rel.add(-2 * num);
                rels.add(rel);
            }
        }

        Integer[] nums2 = store.keySet().toArray(new Integer[0]);

        for(int i = 0; i< nums2.length-2;i++){
            for(int j = i+1; j< nums2.length-1; j++){
                int rest = -1 * (nums2[i] + nums2[j]);
                if(store.containsKey(rest) && rest>nums2[i] && rest>nums2[j]){
                    List<Integer> rel = new ArrayList<>();
                    rel.add(nums2[i]);
                    rel.add(nums2[j]);
                    rel.add(rest);
                    rels.add(rel);
                }

            }
        }
        return rels;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> rels = new ArrayList<List<Integer>>();
        if(nums.length <3){
            return new ArrayList<List<Integer>>();
        }

        // put all of the numbers to tree map item->number
        // 1. if key=0, number =3, return [0,0,0]
        // 2. Map[i:], for key<0, if exist key1=0, key2=-key, store
        // 3. Map[i:], for key<0, value =2, if exit key1=-2* key, store
        // 4. Map[i:]
        Map<Integer, Integer> store = new TreeMap<Integer, Integer>();
        for(Integer num:nums){
            if(store.containsKey(num)){
                store.put(num,store.get(num)+1);
            }else{
                store.put(num, 1);
            }
        }

        if(store.containsKey(0)){
            if(store.get(0)>=3){
                List<Integer> rel = new ArrayList<>();
                rel.add(0);
                rel.add(0);
                rel.add(0);
                rels.add(rel);
            }
            for(Integer num : store.keySet()){
                if(num<0 && store.containsKey(-1*num)){
                    List<Integer> rel = new ArrayList<>();
                    rel.add(num);
                    rel.add(0);
                    rel.add(-1 * num);
                    rels.add(rel);
                }
            }
        }

        store.remove(0);

        for(Integer num : store.keySet()){
            if(store.get(num) >=2 && store.containsKey(num * -2)){
                List<Integer> rel = new ArrayList<>();
                rel.add(num);
                rel.add(num);
                rel.add(-2 * num);
                rels.add(rel);
            }
        }

        Integer[] nums2 = store.keySet().toArray(new Integer[0]);

        for(int i = 0; i< nums2.length-2;i++){
            for(int j = i+1; j< nums2.length-1; j++){
                for(int k=j+1; k < nums2.length;k++){
                    if(nums2[i] + nums2[j] + nums2[k] == 0){
                        List<Integer> rel = new ArrayList<>();
                        rel.add(nums2[i]);
                        rel.add(nums2[j]);
                        rel.add(nums2[k]);
                        rels.add(rel);
                    }
                }
            }
        }
        return rels;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        if(nums.length <3){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> rels = new ArrayList<List<Integer>>();

        Map<Integer, Integer> exist = new HashMap<>();
        for(int i = 0; i< nums.length-2;i++){
            for(int j = i+1; j< nums.length-1; j++){
                for(int k=j+1; k < nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){

                        if(exist.containsKey(nums[i]) && (exist.get(nums[i])==nums[j] || exist.get(nums[i])==nums[k])
                                || exist.containsKey(nums[j]) && (exist.get(nums[j])==nums[i] || exist.get(nums[j])==nums[k])
                                || exist.containsKey(nums[k]) && (exist.get(nums[k])==nums[i] || exist.get(nums[k])==nums[j])){
                            continue;
                        }else{
                            exist.put(nums[i], nums[j]);
                            exist.put(nums[j], nums[k]);
                            exist.put(nums[k], nums[i]);

                            List<Integer> rel = new ArrayList();
                            rel.add(nums[i]);
                            rel.add(nums[j]);
                            rel.add(nums[k]);
                            rels.add(rel);
                        }
                    }
                }
            }
        }
        return  rels;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <3){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> rels = new ArrayList<List<Integer>>();

        for(int i = 0; i< nums.length-2;i++){
            for(int j = i+1; j< nums.length-1; j++){
                for(int k=j+1; k < nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> rel = new SumList();
                        rel.add(nums[i]);
                        rel.add(nums[j]);
                        rel.add(nums[k]);
                        // sort?
                        rel.sort(new SortInteger());
                        // compare
                        if(!rels.contains(rel)){
                            rels.add(rel);
                        }
                    }
                }
            }
        }
        return  rels;
    }

    static class SortInteger implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
           return o1-o2;
        }
    }

    static class SumList extends ArrayList<Integer>{
        @Override
        public boolean equals(Object o) {
            if(o instanceof SumList){
                SumList sl = (SumList)o;
                return sl.get(0) == this.get(0) && sl.get(1) == this.get(1);
            }
            return super.equals(o);
        }
    }
}
