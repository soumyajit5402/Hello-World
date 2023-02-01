class Solution {
    public void flatten(TreeNode root) {
        getPreOrderTraversal(root, null);
    }

    private TreeNode getPreOrderTraversal(TreeNode node, TreeNode rightHalf) {
        if (node == null) return rightHalf;
        node.right = getPreOrderTraversal(node.left, getPreOrderTraversal(node.right, rightHalf));
        node.left = null;
        return node;
    }
}