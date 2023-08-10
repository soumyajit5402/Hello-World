//k largest or k smallest element , heap , min rope -- heap solution 
class Solution {

    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE ; 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3); 
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(set.contains(nums[i])) {
                continue;
            }
            if(pq.size()== 3) {
                if(pq.peek()>nums[i]){
                    continue;
                }
               int val =  pq.poll();
            //    max = Math.max(max , val);
            }
            pq.add(nums[i]);
            set.add(nums[i]);
        }

      
      if(pq.size()==2){
         int max1 = pq.poll();
          int max2 = pq.poll();
         return Math.max(max1, max2);
      }else {
             return pq.peek();
      }
    

    }
}