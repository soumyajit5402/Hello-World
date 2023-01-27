class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return result;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int heightLeft = getHeight(root.left);
        int heightRight = getHeight(root.right);
        result &= (Math.abs(heightLeft - heightRight) <= 1);
        return 1 + Math.max(heightLeft, heightRight);
    }
}