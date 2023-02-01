class Solution {
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);
        return build(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
    }
    
    TreeNode build(int io_left, int io_right, int[] inorder, int po_left, int po_right, int[] postorder) {
        if (io_right < io_left) return null;
        if (io_right == io_left) return new TreeNode(inorder[io_left]);
        
        int io_index = indexMap.get(postorder[po_right]);
        int leftLen = io_index - io_left;
        
        TreeNode currNode = new TreeNode(postorder[po_right]);
        currNode.left = build(io_left, io_index - 1, inorder, po_left, po_left + leftLen - 1, postorder);
        currNode.right = build(io_index + 1, io_right, inorder, po_left + leftLen, po_right - 1, postorder);
        return currNode;
    }
}