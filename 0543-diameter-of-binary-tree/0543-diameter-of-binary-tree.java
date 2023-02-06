class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        computeDiameter(root);
        return max - 1;
    }
    
    private int computeDiameter(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = computeDiameter(node.left);
        int rightHeight = computeDiameter(node.right);
        max = Math.max(max, leftHeight + 1 + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}