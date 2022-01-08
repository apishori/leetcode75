/*
for each bit, if last bit is 1 increment count, shift n right by 1. If n is 0 then break early.
*/
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; ++i) {
            if(n == 0) break;
            if((n & 1) == 1) ++count;
            n >>= 1;
        }
        return count;
    }
}