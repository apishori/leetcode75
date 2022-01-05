/*
keep a running sum of nums and reset the sum if it goes negative. Update max sum each loop
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if(currSum < 0) currSum = 0;
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
