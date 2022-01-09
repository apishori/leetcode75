/*
Same dp as house robber, however run twice on 0 to n - 2 and 1 to n - 1 and max is returned.
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(robLine(nums, 0, n - 1), robLine(nums, 1, n));
    }
    
    // dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2])
    // dp[0] = nums[0], dp[-1] = 0;
    private int robLine(int[] nums, int start, int end) {
        int prevProfit = nums[start], prev2Profit = 0;
        for(int i = start + 1; i < end; ++i) {
            int profit = Math.max(prevProfit, nums[i] + prev2Profit);
            prev2Profit = prevProfit;
            prevProfit = profit;
        }
        return prevProfit;
    }
}