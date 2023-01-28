class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(nums[i])) {
                int pos = container.get(nums[i]);
                if (i - pos <= k) return true;
            }
            container.put(nums[i], i);
        }
        return false;
    }
}