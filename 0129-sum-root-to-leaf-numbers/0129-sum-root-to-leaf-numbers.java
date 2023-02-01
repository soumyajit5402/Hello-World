class Solution {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        countSum(root, 0);
        return total;
    }
    
    private void countSum(TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        if (root.left != null) countSum(root.left, sum);
        if (root.right != null) countSum(root.right, sum);
    }
}