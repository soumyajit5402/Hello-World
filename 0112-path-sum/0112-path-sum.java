
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkSum(root, 0, targetSum); 
    }
    
    boolean checkSum(TreeNode node, int sum, int target) {
        if (node == null) return false;
        sum += node.val;
        if (node.left == null && node.right == null) return sum == target;
        return checkSum(node.left, sum, target) || checkSum(node.right, sum, target);
    }
}