/*
DFS: return number of nodes found and once it hits 2 then set lca and stop searching
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

    TreeNode res = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p.val, q.val);
        return res;
    }
    
    private int findLCA(TreeNode node, int pVal, int qVal) {
        if(node == null || res != null) return 0;
        
        int numFound = findLCA(node.left, pVal, qVal);
        numFound += findLCA(node.right, pVal, qVal);
        if(node.val == pVal || node.val == qVal) ++numFound;
        
        if(numFound == 2 && res == null) res = node;
        
        return numFound;
    }
}