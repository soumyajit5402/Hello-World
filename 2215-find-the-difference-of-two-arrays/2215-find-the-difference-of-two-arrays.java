class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> container1 = new HashSet<>();
        for (int num : nums1) container1.add(num);
        List<Integer> result1 = new ArrayList<>();
        
        Set<Integer> container2 = new HashSet<>();
        for (int num : nums2) container2.add(num);
        List<Integer> result2 = new ArrayList<>();
        
        for (int num : container1) {
            if (!container2.contains(num)) {
                result1.add(num);
            }
        }
        
        for (int num : container2) {
            if (!container1.contains(num)) {
                result2.add(num);
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        return result;
    }
}