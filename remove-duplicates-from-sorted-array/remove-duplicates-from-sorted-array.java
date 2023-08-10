class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer , Integer> map  = new LinkedHashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
          int val =   map.getOrDefault(nums[i], 0 ); 
          map.put(nums[i], val+1);
        }
        int k = 0; 
        for(int num : map.keySet()) {
             nums[k++] = num; 
        }
       map = null ; 
       return k ; 
    }
}