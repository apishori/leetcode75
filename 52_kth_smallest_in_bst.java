import java.util.*;
/*
DFS inorder traversal: fill out a sorted array with values and return k - 1 value
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
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sorted = new ArrayList<>();
        dfs(sorted, root);
        return sorted.get(k - 1);
    }
    
    private void dfs(List<Integer> sorted, TreeNode node) {
        if(node == null) return;
        dfs(sorted, node.left);
        sorted.add(node.val);
        dfs(sorted, node.right);
    }
}