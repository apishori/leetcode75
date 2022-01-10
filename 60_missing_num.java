/*
Sum all (indices + 1) and all nums[i]. The diff is the missing number
*/
class Solution {
    public int missingNumber(int[] nums) {
        int numSum = 0, indSum = 0;
        for(int i = 0; i < nums.length; i++) {
            numSum += nums[i];
            indSum += i + 1;
        }
        return indSum - numSum;
    }
}