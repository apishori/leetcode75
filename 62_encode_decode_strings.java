import java.util.*;
/*
Encode each str as len(str) + '.' + str, i.e. ["Hello","World"] -> "5.Hello5.World"
*/
class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length());
            sb.append('.');
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> res = new ArrayList<>();
        while(i < s.length()) {
            int j = i; 
            while(s.charAt(j) != '.') ++j;
            int numChars = Integer.parseInt(s.substring(i, j++));
            i = j + numChars;
            res.add(s.substring(j, i));
        }
        return res;
    }
}