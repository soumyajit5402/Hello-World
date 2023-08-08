 class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = findFirstPositiveIndex(nums);
        System.out.println("findFirstPositiveIndex:"+ i);
        int neg = i-1 ; 
        int pos = i;
        int res [] = new int[nums.length];
        int j =0 ; 
        if(i == 0) {
             System.out.println("i==0");
           return simpleTraverse(nums);
        }
        
        if(i == nums.length) {
              System.out.println("i == nums.length");
           int temp[] =  reverserArray(nums);
           return simpleTraverse(temp);
        }
        
        while(neg>=0 && pos < nums.length) {
             System.out.println("pos::"+ pos+" neg::"+neg);
            if(Math.abs(nums[neg]) < nums[pos]) {          
                res[j++] = Math.abs(nums[neg]*nums[neg]);
                neg--;     
            } else {      
                res[j++] = Math.abs(nums[pos]*nums[pos]);
                pos++;
                
            }
        }
        if(pos == nums.length) {
            for(i = neg ; i >=0 ; i--){
                res[j++] = Math.abs(nums[i]*nums[i]);
            }
            return res ; 
        }
        if(neg<0) {
             for(i = pos ; i<nums.length ; i++){
                res[j++] = Math.abs(nums[i]*nums[i]);
            }
            return res ; 
        }
        return res; 
    }
     

     
     private int[] simpleTraverse(int[] nums) {
          int res[] = new int[nums.length];
          for(int i = 0 ; i < nums.length ; i++) {
                res[i] = Math.abs(nums[i]*nums[i]);
            }
            return res;
     }
    private int findFirstPositiveIndex(int[] nums) {
        int i = 0 ;
        for(int num : nums) {
            if(num<0) {
                i++;
            } else {
                return i ;
            }
        }  
      return i ;
    }
     
     private int[] reverserArray(int [] nums) {
         int res[] = new int[nums.length];
         int count = 0 ;
         for(int i = nums.length-1 ; i >= 0 ; i--){
             res[count++] = nums[i]; 
         }
         return res;
     }
}