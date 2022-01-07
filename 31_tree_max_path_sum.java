/*
Store best path as private variable and recurse through tree returning best one-sided path
and updating best path at each level.
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

    int bestPathSum;

    public int maxPathSum(TreeNode root) {
        bestPathSum = Integer.MIN_VALUE;
        helper(root);
        return bestPathSum;
    }
    
    private int helper(TreeNode node) {
        if(node == null) return 0;
        
        int leftPath = Math.max(helper(node.left), 0);
        int rightPath = Math.max(helper(node.right), 0);
        
        bestPathSum = Math.max(bestPathSum, leftPath + node.val + rightPath);
        
        return node.val + Math.max(leftPath, rightPath);
    }
}