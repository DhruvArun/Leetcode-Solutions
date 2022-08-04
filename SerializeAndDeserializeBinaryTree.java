import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

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

class SerializeAndDeserializeBinaryTree {
    public int i = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        
        dfs(root, result);
        
        return String.join(",", result);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        
        TreeNode result = dfs(vals);
        
        return result;
    }
    
    public void dfs(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("N");
            return;
        }
        
        result.add(Integer.toString(node.val));
        
        dfs(node.left, result);
        dfs(node.right, result);
    }
    
    public TreeNode dfs(String[] vals) {        
        if (vals[this.i].equals("N")) {
            this.i++;
            return null;
        }
        
        var node = new TreeNode(Integer.parseInt(vals[this.i]));
        this.i++;
        
        node.left = dfs(vals);
        node.right = dfs(vals);
        
        return node;    
    }
}
