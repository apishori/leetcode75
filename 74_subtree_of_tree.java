/*
Search root tree to find a node matching subRoots val and then run same tree algorithm
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) return false;
        if(root.val == subRoot.val && sameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private boolean sameTree(TreeNode n1, TreeNode n2) {
        if(n1 == null || n2 == null) return n1 == null && n2 == null;
        return n1.val == n2.val && sameTree(n1.left, n2.left) && sameTree(n1.right, n2.right);
    }
}
