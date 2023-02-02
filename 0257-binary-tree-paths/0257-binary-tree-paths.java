/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traverseTree(root, new LinkedList<>());
        return ans;
    }
    
    private void traverseTree(TreeNode node, LinkedList<String> list) {
        list.add(node.val + "");
        if (node.left == null && node.right == null) ans.add(String.join("->", list));
        if (node.left != null) traverseTree(node.left, list);
        if (node.right != null) traverseTree(node.right, list);
        list.removeLast();
    }
}