class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }
    
    void inorderTraversal(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        inorderTraversal(node.left, ans);
        ans.add(node.val);
        inorderTraversal(node.right, ans);
    }
}