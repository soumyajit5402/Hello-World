class Solution {
    List<Integer> container = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return container;
        container.add(root.val);
        for (Node child : root.children) preorder(child);
        return container;
    }
}