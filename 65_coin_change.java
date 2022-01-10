/*
dp bottom up: dp[i] = min(dp[i - coin] + 1), for every coin <= i. dp[0] = 0.
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i) {
            dp[i] = amount + 1;
            for(int coin : coins) {
                if(coin > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}