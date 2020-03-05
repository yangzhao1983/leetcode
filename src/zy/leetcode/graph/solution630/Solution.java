package zy.leetcode.graph.solution630;

import java.util.*;

public class Solution {

    // initial status: (t1, d1), (t2, d2) ... (tn, dn), where t1 < t2 < t3 <.. < tn
    // given optimal solution pq: <ti1, di1>, <ti2, di2>, ...<tin, din> ordered by ti
    // try to add <tin+1, din+1> to pq, if ∑di + din+1 < tin+1, then it is ok
    // else, get <tj, dj>, where dj = max(di), if dj >= din+1, remove <tj, dj> from pq, add <tin+1, din+1>
    public int scheduleCourse(int[][] courses) {
        List<List<Integer>> listCourses = new ArrayList<>();
        for(int i = 0; i<courses.length; i++){
            List<Integer> listCourse = new ArrayList<>();
            listCourse.add(courses[i][0]); // d
            listCourse.add(courses[i][1]); // t
            listCourses.add(listCourse);
        }

        Collections.sort(listCourses, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        PriorityQueue<List<Integer>> scheduled = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) - o1.get(0);
            }
        });

        int sumOfD = 0;
        for(List<Integer> course: listCourses){
            if(sumOfD + course.get(0) <= course.get(1)){
                scheduled.add(course);
                sumOfD += course.get(0);
            }else{
                List<Integer> longestCourse = scheduled.peek();
                if(longestCourse!=null && longestCourse.get(0) > course.get(0)){
                    scheduled.remove(longestCourse);
                    scheduled.add(course);
                    sumOfD += course.get(0);
                    sumOfD -= longestCourse.get(0);
                }
            }
        }

        return scheduled.size();
    }

    private static void test1(){
        Solution sol = new Solution();
        int[][] courses = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(sol.scheduleCourse(courses));
    }

    private static void test2(){
        Solution sol = new Solution();
        int[][] courses = new int[][]{{1, 2}, {2, 3}};
        System.out.println(sol.scheduleCourse(courses));
    }

    private static void test3(){
        Solution sol = new Solution();
        int[][] courses = new int[][]{{9,14},{7,12},{1,11},{4,7}};
        System.out.println(sol.scheduleCourse(courses));
    }

    private static void test4(){
        Solution sol = new Solution();
        int[][] courses = new int[][]{{100,2},{32,50}};
        System.out.println(sol.scheduleCourse(courses));
    }

    public static void main(String...strings){
        test1();
        test2();
        test3();
        test4();
    }
}
