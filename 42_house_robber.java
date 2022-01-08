/*
dp: dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]), dp[-1] = 0, dp[0] = nums[0];
*/
class Solution {
    public int rob(int[] nums) {
        int prev2Profit = 0, prevProfit = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            int profit = Math.max(prevProfit, prev2Profit + nums[i]);
            prev2Profit = prevProfit;
            prevProfit = profit;
        }
        return prevProfit;
    }
}