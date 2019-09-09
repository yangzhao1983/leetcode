package zy.leetcode.graph.solution997;

/**
 * Created by kaiser_zhao on 2019/9/9.
 */
public class FindByGraph {

    public static void main(String...strings){
        testcase1();
        testcase2();
        testcase3();
        testcase4();
        testcase5();
        testcase6();
    }

    public static void testcase1() {
        int N = 2;
        int[][] trust = {{1, 2}};
        System.out.println(findJudge(N, trust));
    }

    public static void testcase2(){
        int N= 3;
        int[][] trust = {{1,3},{2,3}};
        System.out.println(findJudge(N, trust));
    }

    public static void testcase3(){
        int N= 3;
        int[][] trust = {{1,3},{2,3},{3,1}};
        System.out.println(findJudge(N, trust));
    }

    public static void testcase4(){
        int N= 3;
        int[][] trust = {{1,2},{2,3}};
        System.out.println(findJudge(N, trust));
    }

    public static void testcase5(){
        int N= 4;
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(N, trust));
    }

    public static void testcase6(){
        int N= 4;
        int[][] trust = {{3,2},{4,1},{3,1},{2,1},{2,3},{4,3},{4,2},{3,4}};
        System.out.println(findJudge(N, trust));
    }

    public static int findJudge(int N, int[][] trust) {
        // if N==1, return 1
        // create two arrays, for each edge (m,n),
        // array_in[m] record number of input degree
        // array_out[n] record number of outpud degree
        // at last, check if exist ans, array_in[k] == N-1 and array_out[k] = 0
        if(N == 1){
            return 1;
        }

        int[] inDegrees = new int[N];
        int[] outDegrees = new int[N];

        for(int[] edge : trust){
            inDegrees[edge[1]-1]++;
            outDegrees[edge[0]-1]++;
        }

        for(int index = 0; index < N; index++ ){
            if(inDegrees[index] == N-1 && outDegrees[index]==0){
                return index+1;
            }
        }

        return -1;
    }
}
