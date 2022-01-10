import java.util.*;
/*
Build adjaceny list for the graph. Run dfs on every unvisited node and incr components
for every new dfs we run.
*/
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] seen = new boolean[n];
        
        int components = 0;
        for(int i = 0; i < n; ++i) {
            if(seen[i]) continue;
            ++components;
            dfs(graph, seen, i);
        }
        return components;
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] seen, int node) {
        seen[node] = true;
        for(int child : graph.get(node)) {
            if(seen[child]) continue;
            dfs(graph, seen, child);
        }
    }
}