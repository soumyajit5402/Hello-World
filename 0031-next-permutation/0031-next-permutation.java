class Solution {
    public void nextPermutation(int[] nums) {
        boolean done = false;
        int len = nums.length;
        for (int x = len-2; x >= 0; x--) {
            if (nums[x] < nums[x+1]) {
                int y = x+1;
                for (; y < len-1; y++) {
                    if (nums[y] > nums[x] && nums[y+1] <= nums[x]) {
                        break;
                    }
                }
                
                // swap with next greater element
                nums[y] = nums[y] + nums[x];
                nums[x] = nums[y] - nums[x];
                nums[y] = nums[y] - nums[x];
                
                int a = x + 1, b = len - 1;
                
                // sort ascending all following elements
                while (a < b) {
                    nums[a] = nums[a] + nums[b];
                    nums[b] = nums[a] - nums[b];
                    nums[a] = nums[a] - nums[b];
                    a++;
                    b--;
                }
                done = true;
                break;
            }
        }
        
        if (!done) {
            Arrays.sort(nums);
        }
        
    }
}