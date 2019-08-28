package zy.leetcode.graph.solution785;

/**
 * Created by kaiser_zhao on 2019/8/22.
 */
public class BiColor {
    private int LEN = 100;
    private boolean[] colors = new boolean[LEN];
    private boolean isBipartite = true;
    private boolean[] isColorited = new boolean[LEN];

    public static void main(String...strings){
        testcase1();
        testcase2();
        testcase3();
        testcase4();
        testcase5();
    }


    public static void testcase3(){
        int[] a1 = null;
        int[] a2 = null;
        int[] a3 = null;
        int[] a4 = null;
        int[][] aa = {a1, a2, a3, a4};
        System.out.println(new BiColor().isBipartite(aa));
    }

    public static void testcase4(){
        int[] a1 = {1};
        int[] a2 = {0,3};
        int[] a3 = {3};
        int[] a4 = {1,2};
        int[][] aa = {a1, a2, a3, a4};
        System.out.println(new BiColor().isBipartite(aa));
    }

    public static void testcase5(){
        int[] a1 = {1,2,3};
        int[] a2 = {0,2};
        int[] a3 = {0,1,3};
        int[] a4 = {0,2};
        int[][] aa = {a1, a2, a3, a4};
        System.out.println(new BiColor().isBipartite(aa));
    }

    public static void testcase2(){
        int[] a1 = {1,2,3};
        int[] a2 = {0,2};
        int[] a3 = {0,1,3};
        int[] a4 = {0,2};
        int[][] aa = {a1, a2, a3, a4};
        System.out.println(new BiColor().isBipartite(aa));
    }

    public static void testcase1(){
        int[] a1 = {1,3};
        int[] a2 = {0,2};
        int[] a3 = {1,3};
        int[] a4 = {0,2};
        int[][] aa = {a1, a2, a3, a4};
        System.out.println(new BiColor().isBipartite(aa));
    }

    public boolean isBipartite(int[][] graph) {
        // boundary
        if(graph==null || graph.length <=1){
            return true;
        }

        for(int i = 0; i<graph.length; i++){

            if(!isBipartite){
                return false;
            }
            if(!isColorited[i]){
                dfs(graph, i);
            }
        }

        return isBipartite;
    }

    private void dfs(int[][] graph, int index){
        if(graph[index]==null || graph[index].length==0){
            return;
        }

        // if it's not bipartite, return
        if(!isBipartite){
            return;
        }

        // marked node as colorited.
        isColorited[index] = true;

        // for every connected node
        for (int i : graph[index]){
            // if it is colorited
            if(isColorited[i]){
                //  if its color is the same current node, isBP = false, return.
                //  else return
                if(colors[i] == colors[index]){
                    isBipartite = false;
                    return;
                }
            }else{
                // else, it is not colorited.
                //  its color should be different from current node
                //  dfs
                colors[i] = !colors[index];
                dfs(graph, i);
            }
        }

    }
}
