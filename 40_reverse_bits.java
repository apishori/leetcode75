/*
for each bit, shift res left by 1, add 1 if n has a 1 in last bit and shift n right by 1.
*/
class Solution {
    public int reverseBits(int n) {
        if(n == 0) return 0;
        
        int res = 0;
        for(int i = 0; i < 32; ++i) {
            res <<= 1;
            if((n & 1) == 1) ++res;
            n >>= 1;
        }
        return res;
    }
}