class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        checkPathSum(root, targetSum, new LinkedList<>());
        return result;
    }
    
    private void checkPathSum(TreeNode node, int targetSum, LinkedList<Integer> currList) {
        if (node == null) return;
        
        targetSum -= node.val;
        currList.add(node.val);
        if (node.left == null && node.right == null && targetSum == 0) result.add(new ArrayList<>(currList));
        if (node.left != null) checkPathSum(node.left, targetSum, currList);
        if (node.right != null) checkPathSum(node.right, targetSum, currList);
        currList.removeLast();
    }
}