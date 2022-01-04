import java.util.*;
/*
hash each string into a count of its characters separated and use as map key with value of the anagram groups
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        int[] count = new int[26];
        for(String s : strs) {
            for(char c : s.toCharArray()) count[c - 'a']++;
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < count.length; ++i) {
                sb.append(count[i]);
                sb.append('-');
            }
            
            String hash = sb.toString();
            if(!m.containsKey(hash)) m.put(hash, new ArrayList<>());
            m.get(hash).add(s);
            
            Arrays.fill(count, 0);
        }
        return new ArrayList<>(m.values());
    }
}