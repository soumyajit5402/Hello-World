class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        
        if (left.length() == 0 && right.length() == 0) return root.val + "";
        else if (left.length() == 0) return root.val + "()" + ((right.length() == 0) ? "" : "(" + right + ")");
        else if (right.length() == 0) return root.val + ((left.length() == 0) ? "" : "(" + left + ")");
        else return root.val + ((left.length() == 0) ? "" : "(" + left + ")") + ((right.length() == 0) ? "" : "(" + right + ")");
    }
}