package zy.leetcode.graph.solution685;

import org.junit.Test;

public class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // traverse edges
        // add vertexes of the edge to the set
        // if the two vertexes are in the same set, return it.
        // head-> children list.
        // union two set, head1-> children_list1 + head1 +  children_list2
        // if vi->vj,
        // 1. vi in set1, vj in set2, union set1 and set2
        // 2. vi and vj not in any set, make new set
        // 3. vi in set1, vj not in any set, add vj to the set
        // 4. vj in set1, vi not in any set, add vi to the set
        // 5. vi in set1, vj in set1, return vi vj
        int nodesCount = edges.length;
        UnionFindSet ufs = new UnionFindSet(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (ufs.find(node1) == ufs.find(node2)) {
                    cycle = i;
                } else {
                    ufs.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }

    @Test
    public void test() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        Solution sol = new Solution();
        int[] ans = sol.findRedundantDirectedConnection(edges);
        System.out.println();
    }

    @Test
    public void test2() {
        int[][] edges = {{2, 1}, {3, 1}, {1, 4}, {4, 2}};
        Solution sol = new Solution();
        int[] ans = sol.findRedundantDirectedConnection(edges);
        System.out.println();
    }

    @Test
    public void test3() {
        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
        Solution sol = new Solution();
        int[] ans = sol.findRedundantDirectedConnection(edges);
        System.out.println();
    }
}

class UnionFindSet{
    private int[] ancestor;
    public UnionFindSet(int n){
        ancestor = new int[n];
        for(int i = 0; i < n; i++) ancestor[i] = i;
    }

    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    public int find(int index){
        if(ancestor[index] != index) ancestor[index] = find(ancestor[index]);
        return ancestor[index];
    }
}
