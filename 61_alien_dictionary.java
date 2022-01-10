import java.util.*;
/*
Build a graph and indegree array using every adjacent pair of words in list by finding first diff char 
(edge case of prefix following str). Run BFS on the graph and decrement indegrees and add 0 indegrees to queue + res.
(edge case of loop in BFS)
*/
class Solution {
    public String alienOrder(String[] words) {
        // Initialize graph with unique nodes
        Map<Character,List<Character>> graph = new HashMap<>();
        Map<Character,Integer> counts = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                counts.putIfAbsent(c, 0);
            }
        }
        
        // Build graph from word list
        for(int i = 0; i < words.length - 1; ++i) {
            String first = words[i];
            String second = words[i + 1];
            
            if(first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            
            int len = Math.min(first.length(), second.length());
            for(int j = 0; j < len; ++j) {
                char f = first.charAt(j);
                char s = second.charAt(j);
                if(f != s) {
                    graph.get(f).add(s);
                    counts.put(s, counts.get(s) + 1);
                    break;
                }
            }
        }
        
        // Run BFS to generate res string
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(char c : counts.keySet()) {
            if(counts.get(c) > 0) continue;
            q.add(c);
        }
        
        while(!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for(char child : graph.get(c)) {
                counts.put(child, counts.get(child) - 1);
                if(counts.get(child) == 0) q.add(child);
            }
        }
        
        return sb.length() < counts.size() ? "" : sb.toString();
    }
}