/*
With 2s complement, a xor b is the addition without carry and (a & b) << 1 is the carry. 
Repeat this until carry is 0
*/
class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int ans = a ^ b;
            int c = (a & b) << 1;
            a = ans;
            b = c;
        }
        return a;
    }
}