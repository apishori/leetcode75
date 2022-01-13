import java.util.*;
/*
Get path from root to each node. Remove common starting parts of both paths.
Switch start node path to all 'U' and append paths
*/
class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public String getDirections(TreeNode root, int p, int q) {
        if(root == null) return "";
        
        LinkedList<Character> pPath = new LinkedList<>();
        LinkedList<Character> qPath = new LinkedList<>();
        findNode(root, p, pPath);
        findNode(root, q, qPath);
        
        while(!pPath.isEmpty() && !qPath.isEmpty()) {
            if(pPath.peekFirst() != qPath.peekFirst()) break;
            pPath.pollFirst();
            qPath.pollFirst();
        }
        
        StringBuilder sb = new StringBuilder();
        if(!pPath.isEmpty()) sb.append("U".repeat(pPath.size()));
        while(!qPath.isEmpty()) {
            sb.append(qPath.pollFirst());
        }
        return sb.toString();
    }
    
    private boolean findNode(TreeNode node, int target, LinkedList<Character> path) {
        if(node == null) return false;
        if(node.val == target) return true;
        
        if(findNode(node.left, target, path)) path.addFirst('L');
        else if(findNode(node.right, target, path)) path.addFirst('R');
        
        return !path.isEmpty();
    }
}