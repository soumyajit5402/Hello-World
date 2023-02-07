class Solution {
    Set<Integer> container = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (container.contains(k - root.val)) return true;
        container.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}