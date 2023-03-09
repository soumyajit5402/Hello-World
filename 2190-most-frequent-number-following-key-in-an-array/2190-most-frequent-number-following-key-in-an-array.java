class Solution {
    public int mostFrequent(int[] nums, int key) {
        int max = 0, maxVal = -1;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == key) {
                counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
                if (counter.get(nums[i]) > max) {
                    max = counter.get(nums[i]);
                    maxVal = nums[i];
                }
            }
        }
        return maxVal;
    }
}