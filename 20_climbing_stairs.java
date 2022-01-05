/*
dp top down: ways(2) = 2, ways(1) = 1, ways(i) = ways(i - 1) + ways(i - 2)
*/
class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int minTwo = 1, minOne = 2;
        for(int i = 3; i <= n; ++i) {
            int curr = minOne + minTwo;
            minTwo = minOne;
            minOne = curr;
        }
        return minOne;
    }
}
