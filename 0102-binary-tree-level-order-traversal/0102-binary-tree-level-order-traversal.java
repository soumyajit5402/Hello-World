class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();
        if (root == null) return container;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode currNode = queue.poll();
                currList.add(currNode.val);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            container.add(currList);
        }
        return container;
    }
}