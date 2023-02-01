class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return generateTree(preorder, 0, len - 1, inorder, 0, len - 1);
    }
    
    private TreeNode generateTree(int[] preorder, int po_left, int po_right, int[] inorder, int io_left, int io_right) {
        if (po_left > po_right || io_left > io_right) return null;
        if (po_left == po_right || io_left == io_right) return new TreeNode(preorder[po_left]);
        
        TreeNode root = new TreeNode(preorder[po_left]);
        
        int inorderIndex = binarySearch(inorder, preorder[po_left], io_left, io_right);
        int leftLength = inorderIndex - io_left;
        
        root.left = generateTree(preorder, po_left + 1, po_left + leftLength, inorder, io_left, inorderIndex - 1);
        root.right = generateTree(preorder, po_left + leftLength + 1, po_right, inorder, inorderIndex + 1, io_right); 
        
        return root;
    }
    
    private int binarySearch(int[] arr, int target, int left, int right) {
        for (int i = left; i <= right; i++) if (arr[i] == target) return i;
        return -1;
    }
}