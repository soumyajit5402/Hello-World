class Solution {
    Map<Integer, Integer> indexMapping = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for (int i = 0; i < inorder.length; i++) indexMapping.put(inorder[i], i);
        return generateTree(preorder, 0, len - 1, inorder, 0, len - 1);
    }
    
    private TreeNode generateTree(int[] preorder, int po_left, int po_right, int[] inorder, int io_left, int io_right) {
        if (po_left > po_right || io_left > io_right) return null;
        if (po_left == po_right || io_left == io_right) return new TreeNode(preorder[po_left]);
        
        TreeNode root = new TreeNode(preorder[po_left]);
        
        int inorderIndex = indexMapping.get(preorder[po_left]);
        int leftLength = inorderIndex - io_left;
        
        root.left = generateTree(preorder, po_left + 1, po_left + leftLength, inorder, io_left, inorderIndex - 1);
        root.right = generateTree(preorder, po_left + leftLength + 1, po_right, inorder, inorderIndex + 1, io_right); 
        
        return root;
    }
}