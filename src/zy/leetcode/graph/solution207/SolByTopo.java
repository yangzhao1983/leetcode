package zy.leetcode.graph.solution207;

import java.util.*;

/**
 * Created by kaiser_zhao on 2019/9/25.
 */
public class SolByTopo {
    public static void main(String...strings){
        testcase2();
    }

    public static void testcase1(){
        int[] nums1 = {1,0};
        int[][] nums ={nums1};
        System.out.println(canFinish(2, nums));
    }

    public static void testcase2(){
        int[] nums1 = {1,0};
        int[] nums2 = {0,1};
        int[][] nums ={nums1,nums2};
        System.out.println(canFinish(2, nums));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }

        Map<Integer, List<Integer>> adjacent= new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            // fill adjacent
            adjacent.computeIfAbsent(prerequisites[i][0], x->new ArrayList<Integer>()).add(prerequisites[i][1]);
        }

        // fill inDegree
        int key = 0;
        while(key < numCourses){
            if(adjacent.get(key)!=null){
                for(int i : adjacent.get(key)){
                    inDegree[i] ++ ;
                }
            }
            key++;
        }

        LinkedList<Integer> coursesWithZeroPre = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                coursesWithZeroPre.push(i);
            }
        }

        while(!coursesWithZeroPre.isEmpty()){
            int courseWithZeroPre = coursesWithZeroPre.pop();
            if(adjacent.get(courseWithZeroPre)!=null){
                for(int i : adjacent.get(courseWithZeroPre)){
                    inDegree[i] --;
                    if(inDegree[i]==0){
                        // if one adjacent course does not have pre courses, add it to queue
                        coursesWithZeroPre.push(i);
                    }
                }
            }
        }

        //return Arrays.stream(inDegree).allMatch(x->x==0);

        for(int i = 0; i<inDegree.length;i++){
            if(inDegree[i] != 0){
                return false;
            }
        }

        return true;
    }
}
