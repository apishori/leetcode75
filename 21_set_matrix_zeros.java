/*
use first row and col as zero indicators with an extra boolean flag for row 0.
update first row and col flags and then fill out matrix with zeros.
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] != 0) continue;
                matrix[0][j] = 0;
                if(i > 0) matrix[i][0] = 0;
                else rowZero = true;
            }
        }
        
        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                if(matrix[i][0] != 0 && matrix[0][j] != 0) continue;
                matrix[i][j] = 0;
            }
        }
        
        if(matrix[0][0] == 0) {
            for(int i = 1; i < m; ++i) matrix[i][0] = 0;
        }
        
        if(rowZero) {
            for(int j = 0; j < n; ++j) matrix[0][j] = 0;
        }
    }
}