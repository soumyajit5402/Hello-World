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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTInternal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTInternal(TreeNode root, long minimum, long maximum) {
        if (root == null) return true;
        if (root.val <= minimum || root.val >= maximum) return false;
        return isValidBSTInternal(root.left, minimum, root.val) &&
               isValidBSTInternal(root.right, root.val, maximum);
    }
}