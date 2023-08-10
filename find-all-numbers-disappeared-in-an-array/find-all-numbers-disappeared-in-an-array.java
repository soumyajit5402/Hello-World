class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i = 0 ; i< nums.length ; i++) {
            int val = Math.abs(nums[i]);
            if(nums[val-1] >0){
               nums[val-1] = -nums[val-1]; 
            }
        }

        List<Integer> res  = new ArrayList<Integer>();
        for(int i = 0 ; i <nums.length ; i++){
            if(nums[i]>0) {
               res.add(i+1);
            }
        }

        return res;
        
    }
}