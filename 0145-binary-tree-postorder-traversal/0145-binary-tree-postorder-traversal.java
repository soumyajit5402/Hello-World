class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        pot(root, result);
        return result;
    }
    
    void pot(TreeNode root, List<Integer> result) {
        if (root == null) return;
        pot(root.left, result);
        pot(root.right, result);
        result.add(root.val);
    }
}