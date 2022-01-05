import java.util.*;
/*
use sliding window and maps of t freq and freq of windows to determine valid substrings.
shrinken window until substring is smallest and still valid. Keep count of unique characters 
to know when window is valid
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        int have = 0, need = tFreq.size();
        int l = 0, r = 0, bestL = 0, bestR = 0, bestLen = -1;
        
        while(r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(tFreq.containsKey(c) && window.get(c).intValue() == tFreq.get(c).intValue()) {
                ++have;
            }
            
            while(l <= r && have == need) {
                c = s.charAt(l);
                if(bestLen == -1 || r - l + 1 < bestLen) {
                    bestLen = r - l + 1;
                    bestL = l;
                    bestR = r;
                }
                
                window.put(c, window.get(c) - 1);
                if(tFreq.containsKey(c) && window.get(c).intValue() < tFreq.get(c).intValue()) {
                    --have;
                }
                ++l;
            }
            ++r;
        }
        return bestLen == -1 ? "" : s.substring(bestL, bestR + 1);
    }
}
