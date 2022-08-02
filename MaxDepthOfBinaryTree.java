import java.util.*;

// Recursive DFS:

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

class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// Iterative DFS:

// class MaxDepthOfBinaryTree {
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
        
//         Stack<List> stk = new Stack<>();
//         stk.add(Arrays.asList(root, 1));
//         int res = 1;
        
//         while (!stk.empty()) {
//             List lst = stk.pop();
//             TreeNode node = (TreeNode) lst.get(0);
//             int depth = (int) lst.get(1);
            
//             if (node != null) {
//                 res = Math.max(res, depth);
//                 stk.add(Arrays.asList(node.left, depth + 1));
//                 stk.add(Arrays.asList(node.right, depth + 1));
//             }
//         }
        
//         return res;
//     }
// }
