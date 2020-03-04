package zy.leetcode.agr1.search.solution407;

import java.util.*;

/**
 * Created by kaiser_zhao on 2019/9/17.
 */
public class SolvedByTraverse {

    private int numVisited = 0;
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null ||heightMap.length <=2 || heightMap[0].length<=2){
            return 0;
        }
        int ans = 0;

        // fence: priority queue, PriorityQueue<List<Integer>>
        // non fence: int[][] 0: non-fence, 1: fence
        PriorityQueue<List<Integer>> fences = new PriorityQueue<>(
                new Comparator<List<Integer>>() {
                    @Override
                    public int compare(List<Integer> o1, List<Integer> o2) {
                        return heightMap[o1.get(0)][o1.get(1)] - heightMap[o2.get(0)][o2.get(1)];
                    }
                }
        );


        int[][] intFence = new int[heightMap.length][heightMap[0].length];
        // initialize intFence and fence
        for(int i = 0; i < heightMap.length; i++){
            for(int j = 0; j < heightMap[0].length; j++){
                if(i==0 || i == heightMap.length - 1 || j == 0 || j == heightMap[i].length-1){
                    // fence
                    intFence[i][j] = 1;
                    List<Integer> fencePoint = new ArrayList<>();
                    fencePoint.add(i);
                    fencePoint.add(j);
                    fences.add(fencePoint);
                    numVisited++;
                }else{
                    intFence[i][j] = 0;
                }
            }
        }

        // 1. find the lowest point in the outermost fence heightMap[iLowestF][jLowestF]
        // 2. for heightMap[iLowestF][jLowestF], check its adjacent points in four sides
        // 3. if none adjacent points are lower than it, create new hence
        // 4. else select the one lower than heightMap[iLowestF][jLowestF], as heightMap[iLowest][jLowest]
        // add heightMap[iLowestF][jLowestF] - heightMap[iLowest][jLowest], recreate fence.
        while(numVisited < heightMap.length * heightMap[0].length){
            List<Integer> lowestFencePoint = fences.poll();

            int iLowestF = lowestFencePoint.get(0);
            int jLowestF = lowestFencePoint.get(1);

            int count = 0;
            // above
            if(iLowestF - 1>0){
                count = dealWithAdjacent(iLowestF, jLowestF, heightMap, intFence, iLowestF-1, jLowestF, fences);
                ans += count;
            }

            // below
            if(iLowestF + 1 < heightMap.length - 1){
                count = dealWithAdjacent(iLowestF, jLowestF, heightMap, intFence, iLowestF+1, jLowestF, fences);
                ans += count;
            }

            // left
            if(jLowestF- 1>0){
                count = dealWithAdjacent(iLowestF, jLowestF, heightMap, intFence, iLowestF, jLowestF-1, fences);
                ans += count;
            }

            // right
            if(jLowestF + 1 < heightMap[iLowestF].length - 1){
                count = dealWithAdjacent(iLowestF, jLowestF, heightMap, intFence, iLowestF, jLowestF+1, fences);
                ans += count;
            }

            lowestFencePoint.remove(lowestFencePoint);
        }


        return ans;
    }

    private int dealWithAdjacent(int hor,int ver, int[][] heightMap, int[][] intFence, int horA, int verA, PriorityQueue<List<Integer>> fences){
        if(intFence[horA][verA] == 0 ){

            // set it as fence
            intFence[horA][verA] = 1;
            List<Integer> fence = new ArrayList<>();
            fence.add(horA);
            fence.add(verA);
            fences.add(fence);
            numVisited++;

            // refresh the new fence point
            if(heightMap[hor][ver] > heightMap[horA][verA]){
                int count = heightMap[hor][ver] - heightMap[horA][verA];
                heightMap[horA][verA] = heightMap[hor][ver];
                return count;
            }
        }
        return 0;
    }

    private static void test1(){
        int[][] points = new int [][] {
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}};
        SolvedByTraverse sol = new SolvedByTraverse();
        System.out.println(sol.trapRainWater(points));
    }

    private static void test2(){
        int[][] points = new int [][] {
                {1,3,3,1,3,2},
                {3,2,1,3,2,3},
                {3,3,3,2,3,1}};
        SolvedByTraverse sol = new SolvedByTraverse();
        System.out.println(sol.trapRainWater(points));
    }

    public static void main(String...strings){
        test2();
    }
}
