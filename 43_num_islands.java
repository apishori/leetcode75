/*
run dfs on grid everytime an island is detected and incr count. When a location is visited convert to 0
*/
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                if(grid[i][j] == '0') continue;
                ++count;
                dfs(grid, i, j);
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for(int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}