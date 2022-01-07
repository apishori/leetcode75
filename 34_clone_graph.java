import java.util.*;
/*
BFS across graph creating copy of nodes. Use a map for visited nodes 
to store the copy nodes reference as the value
*/
class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        m.put(node.val, new Node(node.val));
        
        while(!q.isEmpty()) {
            Node curr = q.remove();
            Node copy = m.get(curr.val);
            
            for(Node neighbor : curr.neighbors) {
                if(!m.containsKey(neighbor.val)) {
                    q.add(neighbor);
                    m.put(neighbor.val, new Node(neighbor.val));
                }
                copy.neighbors.add(m.get(neighbor.val));
            }
        }
        return m.get(node.val);
    }
}