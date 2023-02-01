class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> container = new LinkedList<>();
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
            container.addFirst(currList); // add in front of queue
        }
        // Collections.reverse(container); <- or use the collection reverse command
        return container;
    }
}