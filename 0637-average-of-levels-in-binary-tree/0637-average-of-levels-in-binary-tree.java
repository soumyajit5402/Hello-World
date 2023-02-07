class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> container = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0d;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            container.add(sum / length);
        }
        return container;
    }
}