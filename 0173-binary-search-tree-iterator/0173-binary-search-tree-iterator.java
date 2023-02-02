class BSTIterator {
    
    int index;
    List<Integer> container;

    public BSTIterator(TreeNode root) {
        container = new ArrayList<>();
        inorderTraversal(root);
        index = 0;
    }
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        container.add(node.val);
        inorderTraversal(node.right);
    }
    
    public int next() {
        return container.get(index++);
    }
    
    public boolean hasNext() {
        return (index < container.size());
    }
}