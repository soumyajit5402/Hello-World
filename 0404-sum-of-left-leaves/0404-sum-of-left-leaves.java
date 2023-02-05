class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return getSumOfLeftLeaves(root, false);
    }
    
    private int getSumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null && isLeft == true) return node.val;
        return getSumOfLeftLeaves(node.left, true) + getSumOfLeftLeaves(node.right, false);
    }
}