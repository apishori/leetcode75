/*
DFS preorder traversal to convert tree into comma sep str and same for deserial
*/
class Codec {
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialHelper(root, sb);
        return sb.toString();
    }
    
    private void serialHelper(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("N");
            return;
        }
        sb.append(node.val);
        sb.append(',');
        serialHelper(node.left, sb);
        sb.append(',');
        serialHelper(node.right, sb);
    }
    
    private int i;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] nodes = data.split(",");
        this.i = 0;
        return deserialHelper(nodes);
    }
    
    private TreeNode deserialHelper(String[] nodes) {
        if(nodes[i].equals("N")) {
            ++i;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i++]));
        node.left = deserialHelper(nodes);
        node.right = deserialHelper(nodes);
        return node;
    }
}