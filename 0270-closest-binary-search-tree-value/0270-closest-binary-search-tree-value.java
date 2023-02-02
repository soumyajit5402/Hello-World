class Solution {
    public int closestValue(TreeNode root, double target) {
        return getClosestValue(root, target).getKey();
    }
    
    private Pair<Integer, Double> getClosestValue(TreeNode node, double target) {
        if (node == null) return new Pair<Integer, Double> (0, 1e18);
        
        Pair<Integer, Double> subTreeAns = new Pair<Integer, Double> (0, 1e18);
        if (node.val > target) subTreeAns = getClosestValue(node.left, target);
        else subTreeAns = getClosestValue(node.right, target);
        
        double currDiff = Math.abs(node.val - target);
        if (currDiff <= subTreeAns.getValue()) return new Pair<Integer, Double> (node.val, currDiff);
        else return subTreeAns;
    }
}