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

class ConstructTreeFromInOrderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        if (preorder.length==1) {
            return root;
        }

        int breakindex = -1;

        for (int i = 0; i< inorder.length; i++) { 
            if (inorder[i]==preorder[0]) { 
                breakindex = i; 
                break;
            } 
        }

        int[] subleftpre  = Arrays.copyOfRange(preorder, 1, breakindex + 1);
        int[] subleftin   = Arrays.copyOfRange(inorder, 0,  breakindex);
        int[] subrightpre = Arrays.copyOfRange(preorder, breakindex + 1, preorder.length);
        int[] subrightin  = Arrays.copyOfRange(inorder, breakindex + 1, inorder.length);

        root.left  = buildTree(subleftpre, subleftin);
        root.right = buildTree(subrightpre, subrightin);

        return root;
    }
}
