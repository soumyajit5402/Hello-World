class Solution {
    public int minOperations(int[] nums) {
        // sort input
        Arrays.sort(nums);
        // extract all unique values into a list in sorted order
        List<Integer> container = new ArrayList<>();
        container.add(nums[0]);
        for (int i = 1; i < nums.length; i++) if (nums[i] != nums[i-1]) container.add(nums[i]);

        // assuming the answer starts at each element in the list, compute minimum changes required
        int minChanges = nums.length - 1;
        for (int i = 0; i < container.size() - 1; i++) {
            int target = container.get(i) + nums.length;
            int index = binarySearch(container, i + 1, container.size() - 1, target);
            int changes = nums.length - (index - i);
            minChanges = Math.min(minChanges, changes);   
        }
        return minChanges;
    }
    
    public int binarySearch(List<Integer> list, int left, int right, int val) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == val) return mid;
            else if (list.get(mid) < val) left = mid + 1;
            else right = mid;
        }
        if (list.get(left) >= val) return left;
        if (list.get(right) >= val) return right;
        return list.size();
    }
}