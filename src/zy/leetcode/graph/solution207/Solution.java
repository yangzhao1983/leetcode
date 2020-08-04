package zy.leetcode.graph.solution207;

import com.sun.tools.corba.se.idl.InterfaceGen;
import sun.jvm.hotspot.debugger.windbg.WindbgDebugger;

import java.util.*;

public class Solution {
    /**
     * for each course, find inDegree
     * find all courses with no pre course
     * for each course, find all courses after it
     *
     * for each course with no pre course, remove it from the set, remove it from the pre courses set of the each course after it.
     * decrease inDegree
     * if the course after it has no pre course, add it to the set of course without any pre courses
     *
     * loop inDegree, if any degree >0, then return false;
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outs = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            outs.computeIfAbsent(prerequisites[i][1], x->new ArrayList<>()).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        LinkedList<Integer> coursesWithoutPre = new LinkedList<>();
        for(int i = 0; i < inDegree.length;i++){
            if(inDegree[i] == 0){
                coursesWithoutPre.push(i);
            }
        }

        while(!coursesWithoutPre.isEmpty()){
            int curCourse = coursesWithoutPre.pop();
            List<Integer> afters = outs.get(curCourse);
            if(afters!= null){
                for(Integer after : afters){
                    inDegree[after]--;
                    if(inDegree[after]==0) coursesWithoutPre.add(after);
                }
            }
        }

        for(int i = 0; i <inDegree.length; i++){
            if(inDegree[i]>0) return false;
        }

        return true;
    }
}
