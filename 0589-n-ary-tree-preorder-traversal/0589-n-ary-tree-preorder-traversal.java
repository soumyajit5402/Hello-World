class Solution {
    List<Integer> container = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        traverse(root);
        return container;
    }
    
    private void traverse(Node node) {
        if (node == null) return;
        container.add(node.val);
        for (Node child : node.children) traverse(child);
    }
}