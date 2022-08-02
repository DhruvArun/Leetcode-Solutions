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

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            
            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        
        return result;
    }
}
