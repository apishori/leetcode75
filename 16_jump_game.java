/*
dp bottom up: keep track of rightmost good pos and keep updating it as we move left.
If the first pos is good then we can reach the end.
*/
class Solution {
    public boolean canJump(int[] nums) {
        int goodPos = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; --i) {
            if(i + nums[i] >= goodPos) goodPos = i;
        }
        return goodPos == 0;
    }
}
