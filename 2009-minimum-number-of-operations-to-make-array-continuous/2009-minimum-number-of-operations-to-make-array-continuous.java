class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        List<Integer> container = new ArrayList<>();
        container.add(nums[0]);
        for (int i = 1; i < nums.length; i++) if (nums[i] != nums[i-1]) container.add(nums[i]);

        int minChanges = Integer.MAX_VALUE;
        for (int i = 0; i < container.size(); i++) {
            int target = container.get(i) + nums.length;
            int index = binarySearch(container, target);
            int changes = nums.length - (index - i);
            minChanges = Math.min(minChanges, changes);   
        }
        return minChanges;
    }
    
    public int binarySearch(List<Integer> list, int val) {
        int left = 0, right = list.size() - 1;
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