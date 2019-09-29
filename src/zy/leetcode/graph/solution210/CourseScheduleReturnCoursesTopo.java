package zy.leetcode.graph.solution210;

import java.util.*;

/**
 * Created by kaiser_zhao on 2019/9/29.
 */
public class CourseScheduleReturnCoursesTopo {
    public static void main(String...strings){
        testcase3();
        testcase2();
        testcase1();
        testcase4();
    }

    private static void testcase2(){

        int[][] nums ={};
        System.out.println("========");

        for(int i : findOrder(2, nums)){
            System.out.println(i);
        }
    }

    private static void testcase1(){
        int[] nums1 = {1,0};
        int[][] nums ={nums1};
        System.out.println("========");

        for(int i : findOrder(2, nums)){
            System.out.println(i);
        }
    }


    private static void testcase4(){
        int[] nums1 = {1,0};
        int[] nums2 = {0,1};
        int[][] nums ={nums1, nums2};
        System.out.println("========");

        for(int i : findOrder(3, nums)){
            System.out.println(i);
        }
    }


    private static void testcase3(){
        int[] nums1 = {1,0};
        int[] nums2 = {2,0};
        int[][] nums ={nums1, nums2};
        System.out.println("========");

        for(int i : findOrder(3, nums)){
            System.out.println(i);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courses = null;

        if(numCourses == 0){
            return courses;
        }else if(numCourses == 1){
            courses = new int[1];
            courses[0] = 0;
            return courses;
        }

        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        int[] inDegree = new int[numCourses];

        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<Integer> nodeWithZeroInDegree = new LinkedList<>();

        for(int i = 0; i<prerequisites.length;i++){
            // fill inDegree
            inDegree[prerequisites[i][0]]++;

            // fill adjacent
            adjacent.computeIfAbsent(prerequisites[i][1], x-> new ArrayList<Integer>()).
                    add(prerequisites[i][0]);
        }

        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                nodeWithZeroInDegree.push(i);
            }
        }

        while(!nodeWithZeroInDegree.isEmpty()){
            int node = nodeWithZeroInDegree.pop();
            ans.add(node);

            // minus 1 for each adjacent
            // if indegree is 0, put it to nodeWithZeroInDegree and ans
            if(adjacent.get(node) == null){
                continue;
            }

            for(int i : adjacent.get(node)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    nodeWithZeroInDegree.push(i);
                }
            }
        }

        boolean getAns = true;

        for(int i = 0; i<inDegree.length; i++){
            if(inDegree[i]!=0){
                getAns = false;
                break;
            }
        }

        if(getAns){
            courses = new int[ans.size()];
            int i = 0;
            while(!ans.isEmpty()){
                courses[i++] = ans.pop();
            }
        }else{
            courses = new int[0];
        }

        return courses;
    }
}
