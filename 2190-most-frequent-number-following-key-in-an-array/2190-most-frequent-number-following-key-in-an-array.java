class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == key) {
                counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            }
        }
        
        int max = 0, maxVal = -1;
        for (int num : counter.keySet()) {
            if (counter.get(num) > max) {
                max = counter.get(num);
                maxVal = num;
            }
        }
        return maxVal;
    }
}