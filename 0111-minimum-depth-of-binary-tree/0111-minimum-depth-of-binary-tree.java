class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minDepthLeft = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int minDepthRight = root.right == null ? Integer.MAX_VALUE : minDepth(root.right);
        return Math.min(minDepthLeft, minDepthRight) + 1;
    }
}