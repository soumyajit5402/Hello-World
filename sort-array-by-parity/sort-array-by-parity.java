class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start = 0 ; 
        int end = nums.length -1 ; 
        while(start < end) {
            if(nums[start]%2 == 0  ) {
                start++;
               continue;
            }
            if(nums[end]%2 !=0) {
                end--;
                continue;
                }
            if(nums[end]%2 == 0 ){
                int temp = nums[end]; 
                nums[end] = nums[start];
                nums[start] = temp ;
                end--;
                start++ ;             
            }
        }
      return  nums;
    }
     

}