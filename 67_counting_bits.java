/*
dp[i] = dp[i / 2] + (i % 2), dp[0] = 0; by shifting i right we divide by 2 and add 1 if last bit is 1
*/
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}