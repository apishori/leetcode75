/*
First save the left side prod in forward pass, then multiply right side prod in backward pass
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < nums.length; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int rightProd = 1;
        for(int i = nums.length - 2; i >= 0; --i) {
            rightProd *= nums[i + 1];
            res[i] *= rightProd;
        }
        return res;
    }
}