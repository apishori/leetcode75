/*
dp bottom up: if c1 == c2: dp[i][j] = dp[i + 1][j + 1] + 1 
else dp[i][j] = max(dp[i + 1][j], dp[i][j + 1]). Where dp[i][j] represents the longest
common substring in s1.substr(i) and s2.substr(j)
*/
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        if(s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        
        int[][] dp = new int[2][s2.length() + 1];
        for(int i = s1.length() - 1; i >= 0; --i) {
            char c1 = s1.charAt(i);
            for(int j = s2.length() - 1; j >= 0; --j) {
                if(c1 == s2.charAt(j)) {
                    dp[0][j] = 1 + dp[1][j + 1];
                } else {
                    dp[0][j] = Math.max(dp[1][j], dp[0][j + 1]);
                }
            }
            
            for(int j = 0; j < s2.length(); ++j) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[0][0];
    }
}