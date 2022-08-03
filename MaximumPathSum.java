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

class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[] {root.val};
        
        dfs(root, res);
        
        return res[0];
    }
    
    // Return max path sum without a split
    
    public int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        
        int leftMax = dfs(root.left, res);
        int rightMax = dfs(root.right, res);
        
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);
        
        // Compute max path sum with a split
        
        res[0] = Math.max(res[0], root.val + leftMax + rightMax);
        
        return root.val + Math.max(leftMax, rightMax);
    }    
}