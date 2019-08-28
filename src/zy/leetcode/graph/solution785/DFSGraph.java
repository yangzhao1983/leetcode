package zy.leetcode.graph.solution785;

/**
 * Created by kaiser_zhao on 2019/8/23.
 */
public class DFSGraph {
    private static boolean[] marked;

    public static void main(String...strings){
        testcase1();
        testcase2();
        testcase4();
    }


    public static void testcase3(){
        int[] a1 = null;
        int[] a2 = null;
        int[] a3 = null;
        int[] a4 = null;
        int[][] aa = {a1, a2, a3, a4};
        marked = new boolean[aa.length];
        for(int i = 0; i<aa.length; i++){
            dfsGraph(aa, i);
        }
    }

    public static void testcase4(){
        int[] a1 = {1};
        int[] a2 = {0,3};
        int[] a3 = {3};
        int[] a4 = {1,2};
        int[][] aa = {a1, a2, a3, a4};
        marked = new boolean[aa.length];
        for(int i = 0; i<aa.length; i++){
            dfsGraph(aa, i);
        }
    }

    public static void testcase2(){
        int[] a1 = {1,2,3};
        int[] a2 = {0,2};
        int[] a3 = {0,1,3};
        int[] a4 = {0,2};
        int[][] aa = {a1, a2, a3, a4};
        marked = new boolean[aa.length];
        for(int i = 0; i<aa.length; i++){
            dfsGraph(aa, i);
        }
    }

    public static void testcase1(){
        int[] a1 = {1,3};
        int[] a2 = {0,2};
        int[] a3 = {1,3};
        int[] a4 = {0,2};
        int[][] aa = {a1, a2, a3, a4};
        marked = new boolean[aa.length];
        for(int i = 0; i<aa.length; i++){
            dfsGraph(aa, i);
        }
    }

    public static void dfsGraph(int[][] graph, int index){
        // if index is visited, return.
        if(marked[index]){
            return;
        }

        // else outout i, and dfs its connected nodes
        System.out.println(index);
        marked[index] = true;

        for(int i : graph[index]){
            dfsGraph(graph, i);
        }
    }
}
