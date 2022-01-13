import java.util.*;
/*
Use BFS from ocean to all reachable cells for both pacific and atlantic.
Return all common reachable cells
*/
class Solution {
    int m;
    int n;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        boolean[][] pacificWater = new boolean[m][n];
        boolean[][] atlanticWater = new boolean[m][n];
        for(int i = 0; i < m; ++i) {
            pacificQueue.add(new int[]{i, 0});
            pacificWater[i][0] = true;
            
            atlanticQueue.add(new int[]{i, n - 1});
            atlanticWater[i][n - 1] = true;
        }
        for(int j = 0; j < n; ++j) {
            pacificQueue.add(new int[]{0, j});
            pacificWater[0][j] = true;
            
            atlanticQueue.add(new int[]{m - 1, j});
            atlanticWater[m - 1][j] = true;
        }
        
        bfs(heights, pacificWater, pacificQueue);
        bfs(heights, atlanticWater, atlanticQueue);
        
        List<List<Integer>> common = new ArrayList<>();
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(pacificWater[i][j] && atlanticWater[i][j]) {
                    common.add(List.of(i, j));
                }
            }
        }
        
        return common;
    }
    
    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> q) {
        while(!q.isEmpty()) {
            int[] loc = q.poll();
            for(int[] d : dirs) {
                int i = loc[0] + d[0];
                int j = loc[1] + d[1];
                if(i < 0 || j < 0 || i == m || j == n || 
                   visited[i][j] || heights[loc[0]][loc[1]] > heights[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                q.add(new int[]{i, j});
            }
        }
    }
}