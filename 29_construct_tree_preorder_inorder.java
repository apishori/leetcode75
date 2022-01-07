import java.util.*;
/*
recursively build tree using preorder for roots and inorder for left and right subtree.
map to keep track of index of rootsß
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

    Map<Integer,Integer> m;
    int rootIdx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        m = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) {
            m.put(inorder[i], i);
        }
        rootIdx = 0;
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int l, int r) {
        if(l > r) return null;
        
        TreeNode root = new TreeNode(preorder[rootIdx++]);
        
        root.left = helper(preorder, l, m.get(root.val) - 1);
        root.right = helper(preorder, m.get(root.val) + 1, r);
        
        return root;
    }
}