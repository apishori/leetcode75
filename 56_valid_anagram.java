/*
if lengths are equal, use hashtable and incr char count for s and decr for t.
Anagrams will have all zeros for count
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] table = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for(int count : table) {
            if(count != 0) return false;
        }
        return true;
    }
}