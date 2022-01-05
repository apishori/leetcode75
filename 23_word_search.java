/*
use backtracking to find a word in the grid, using dfs to search through a word. 
set prev character to dummy char to prevent going back in the word.
*/
class Solution {
    char[][] board;
    int m, n;
    String word;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(backtrack(i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(int i, int j, int index) {
        if(index == word.length()) return true;
        
        if(i < 0 || j < 0 || i == m || j == n || word.charAt(index) != board[i][j]) {
            return false;
        }
        
        boolean res = false;
        board[i][j] = '#';
        for(int[] d : dirs) {
            if(backtrack(i + d[0], j + d[1], index + 1)) {
                res = true;
                break;
            }
        }
        board[i][j] = word.charAt(index);
        return res;
    }
}
