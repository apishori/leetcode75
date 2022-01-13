/*
For every possible center build palindrome around it and increase res.
Total of 2n - 1 centers, n odd centers and n - 1 even centers.
*/
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); ++i) {
            ans += palindromesAroundCenter(s, i, i);
            ans += palindromesAroundCenter(s, i, i + 1);
        }
        return ans;
    }
    
    private int palindromesAroundCenter(String s, int L, int R) {
        int ans = 0;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            ++ans;
            --L;
            ++R;
        }
        return ans;
    }
}