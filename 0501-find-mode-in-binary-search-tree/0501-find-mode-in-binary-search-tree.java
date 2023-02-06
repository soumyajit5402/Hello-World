class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int[] findMode(TreeNode root) {
        traverse(root);
        
        int count = 0, max = Integer.MIN_VALUE;
        for (Integer i : hm.keySet()) {
            if (hm.get(i) > max) {
                max = hm.get(i);
                count = 1;
            } else if (hm.get(i) == max) {
                count++;
            }
        }
        
        int[] ans = new int[count];
        for (Integer i : hm.keySet()) {
            if (hm.get(i) == max) ans[--count] = i;
        }
        return ans;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        hm.put(root.val, hm.getOrDefault(root.val, 0) + 1);
        traverse(root.left);
        traverse(root.right);
    }
}