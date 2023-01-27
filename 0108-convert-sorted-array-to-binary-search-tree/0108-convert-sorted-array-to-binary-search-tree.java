class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }
    
    TreeNode createBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, left, mid-1);
        root.right = createBST(nums, mid+1, right);
        return root;
    }
}