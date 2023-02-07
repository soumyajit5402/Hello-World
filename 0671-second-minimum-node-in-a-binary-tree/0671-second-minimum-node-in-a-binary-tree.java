class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return findMin(root, root.val);
    }
    
    private int findMin(TreeNode node, int min) {
        if (node == null) return -1;
        if (node.val > min) return node.val;
        int leftAns = findMin(node.left, min);
        int rightAns = findMin(node.right, min);
        if (leftAns == -1 || rightAns == -1) return leftAns + rightAns + 1;
        else return Math.min(leftAns, rightAns);
    }
}