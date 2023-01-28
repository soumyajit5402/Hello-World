class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> container = new ArrayList<>();
        getPreorderTraversal(root, container);
        return container;
    }
    
    private void getPreorderTraversal(TreeNode root, List<Integer> container) {
        if (root == null) return;
        container.add(root.val);
        getPreorderTraversal(root.left, container);
        getPreorderTraversal(root.right, container);
    }
}