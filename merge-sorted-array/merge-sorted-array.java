class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0 ) {
            return ;
        }
        if(m== 0) { 
            for(int i = 0 ; i<nums1.length; i++){
                nums1[i] =nums2[i];
            }  
            return ;
        }
        int pos1 = m-1 ;   
        int pos2 = n-1 ; 
        
        for(int i = nums1.length-1 ; i >=0 ; i--) {
          if(pos1<0) {
               nums1[i] = nums2[pos2--]; 
          }else if(pos2 <0){
              break;
          }else if(nums1[pos1]> nums2[pos2]){
              nums1[i] = nums1[pos1];
              pos1--; 
          } else if(nums1[pos1]<=nums2[pos2]){
              nums1[i] = nums2[pos2];
              pos2-- ; 
              
          }
        }
        
         
    }
    
}