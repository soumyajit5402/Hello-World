class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return checkSubtree(root, subRoot, false);
    }
    
    private boolean checkSubtree(TreeNode tn1, TreeNode tn2, boolean isChecked) {
        if (tn1 == null && tn2 == null) return true;
        if (tn1 == null || tn2 == null) return false;
        
        if (!isChecked) {
            return checkSubtree(tn1.left, tn2, false) || 
                   checkSubtree(tn1.right, tn2, false) ||
                   ((tn1.val == tn2.val) && checkSubtree(tn1.left, tn2.left, true) && checkSubtree(tn1.right, tn2.right, true)); 
        } else {
            return ((tn1.val == tn2.val) && checkSubtree(tn1.left, tn2.left, true) && checkSubtree(tn1.right, tn2.right, true));
        }
    }
}