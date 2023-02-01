class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> container = new LinkedList<>();
        container.add(root);
        while (!container.isEmpty()) {
            int len = container.size();
            Node prev = container.poll();
            if (prev.left != null) container.add(prev.left);
            if (prev.right != null) container.add(prev.right);
            for (int i = 1; i < len; i++) {
                Node curr = container.poll();
                prev.next = curr;
                prev = curr;
                if (prev.left != null) container.add(prev.left);
                if (prev.right != null) container.add(prev.right);
            }
            prev.next = null;
        }
        return root;
    }
}