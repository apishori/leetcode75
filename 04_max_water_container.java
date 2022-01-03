/*
Two pointers at ends, and move pointer with shorter height
*/
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while(l < r) {
            res = Math.max(res, (r - l) * Math.min(height[r], height[l]));
            if(height[r] < height[l]) r--;
            else l++;
        }
        return res;
    }
}
