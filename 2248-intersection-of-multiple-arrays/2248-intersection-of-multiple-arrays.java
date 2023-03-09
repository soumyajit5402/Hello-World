class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int[] arr : nums) {
            for (int num : arr) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }
        
        for (int num : count.keySet()) {
            if (count.get(num) == nums.length) {
                result.add(num);
            }
        }
        
        Collections.sort(result);
        return result;
    }
}