 class Solution {

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0 , right  = nums.length-1;
        for(int idx = nums.length-1 ; idx >= 0; idx--){
            if(nums[left]* nums[left] > nums[right] * nums[right]){
                res[idx] = nums[left] * nums[left];
                left++;
            }else {
                res[idx] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

 }