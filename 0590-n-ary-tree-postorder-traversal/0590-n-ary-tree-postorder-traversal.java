class Solution {
    List<Integer> container = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return container;
        for (Node child : root.children) postorder(child);
        container.add(root.val);
        return container;
    }
}