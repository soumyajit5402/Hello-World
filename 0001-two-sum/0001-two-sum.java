class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            int index = container.getOrDefault(delta, -1);
            if (index != -1) return new int[] { index, i };
            container.put(nums[i], i);
        }
        return new int[2];
    }
}