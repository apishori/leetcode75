import java.util.*;
/*
Graph is tree if all nodes are connected & no cycles. Convert edges to adjacency list
and run dfs on first node. If a prev seen node is seen again then cycle exists.
If at the end we haven't seen all nodes then graph is not fully connected
*/
class Solution {
    private List<List<Integer>> graph;
    public boolean validTree(int n, int[][] edges) {
        graph = new ArrayList<>();
        for(int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for(int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }
        Set<Integer> seen = new HashSet<>();
        if(hasCycle(seen, 0, -1)) return false;
        return seen.size() == n;
    }
    
    private boolean hasCycle(Set<Integer> seen, int node, int parent) {
        seen.add(node);
        for(int child : graph.get(node)) {
            if(parent == child) continue;
            if(seen.contains(child) || hasCycle(seen, child, node)) return true;
        }
        return false;
    }
}