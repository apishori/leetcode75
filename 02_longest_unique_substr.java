import java.util.*;
/*
Use a map of the character to its index to tell if we find a duplicate character.
Keep track of the current start of the substring and update max length according
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, start = 0;
        Map<Character,Integer> m = new HashMap<>();
        for(int i = 0 ; i < s.length(); ++i) {
            char c = s.charAt(i);
            int pos = m.getOrDefault(c, -1);
            if(pos >= start) start = pos + 1;
            m.put(c, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
