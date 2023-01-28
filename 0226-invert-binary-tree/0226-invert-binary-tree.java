class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tempRight = invertTree(root.left);
        TreeNode tempLeft = invertTree(root.right);
        root.right = tempRight;
        root.left = tempLeft;
        return root;
    }
}