/*
if both p and q are greater than node val then move node to right and vice versa
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null) {
            if(p.val > curr.val && q.val > curr.val) curr = curr.right;
            else if(p.val < curr.val && q.val < curr.val) curr = curr.left;
            else return curr;
        }
        return null;
    }
}