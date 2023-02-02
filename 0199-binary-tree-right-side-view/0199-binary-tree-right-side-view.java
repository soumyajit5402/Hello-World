class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> container = new LinkedList<>();
        if (root != null) container.add(root);
        
        while (!container.isEmpty()) {
            int len = container.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = container.poll();
                if (i == len-1) result.add(curr.val);
                if (curr.left != null) container.add(curr.left);
                if (curr.right != null) container.add(curr.right);
            }
        }
        return result;
    }
}