/*
sliding window: move r until window len - max char freq > k then move l.
Keep track of best window len as result, and store max char freq to improve access time
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, maxLen = 0, maxFreq = 0;
        int[] counts = new int[26];
        for(int r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            ++counts[c - 'A'];
            maxFreq = Math.max(maxFreq, counts[c - 'A']);
            
            while((r - l + 1) - maxFreq > k) {
                --counts[s.charAt(l) - 'A'];
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}