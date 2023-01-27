class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrorImage(root.left, root.right);
    }
    
    private boolean isMirrorImage(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        else if (right == null) return false;
        else return (left.val == right.val && 
                     isMirrorImage(left.left, right.right) && 
                     isMirrorImage(left.right, right.left));
    }
}