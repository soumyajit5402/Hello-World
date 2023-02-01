class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, curr = 0;
        while (curr <= right) {
            if (nums[curr] == 0) swap(nums, curr++, left++);
            else if (nums[curr] == 2) swap(nums, curr, right--); // don't increment current pointer
            else curr++;
        }
    }
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;            
    }
}