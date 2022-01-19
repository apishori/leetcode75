import java.util.*;
/*
backtrack through all possible queen pos. Keep track 
of cols and diagonals using sets and basic math operations
*/
class Solution {
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    int n;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        
        backtrack(res, board, 0);
        return res;
    }
    
    private void backtrack(List<List<String>> res, char[][] board, int r) {
        if(r == n) {
            res.add(generateBoard(board));
            return;
        }
        
        for(int c = 0; c < n; ++c) {
            if(cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }
            
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';
            
            backtrack(res, board, r + 1);
            
            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
    
    private List<String> generateBoard(char[][] board) {
        List<String> b = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) sb.append(board[i][j]);
            b.add(sb.toString());
            sb.setLength(0);
        }
        return b;
    }
}