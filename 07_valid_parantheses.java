import java.util.*;
/*
Use a stack to keep track of the open paran and every closing paran found should
match the top of the stacks paran.
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                char top = st.isEmpty() ? '.' : st.pop();
                if(c == ')' && top != '(') return false;
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
            }
        }
        return st.isEmpty();
    }
}
