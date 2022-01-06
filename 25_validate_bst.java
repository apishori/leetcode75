/*
inorder traversal, save prev value and make sure curr is greater than prev
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

    Integer prev;
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    private boolean inorder(TreeNode node) {
        if(node == null) return true;
        
        if(!inorder(node.left)) return false;
        
        if(prev != null && prev >= node.val) return false;
        prev = node.val;
        
        return inorder(node.right);
    }
}
