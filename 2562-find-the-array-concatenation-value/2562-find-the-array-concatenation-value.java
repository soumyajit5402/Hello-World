class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long concatenatedValue = 0l;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right) concatenatedValue += (long)nums[left++];
            else concatenatedValue += concatenate((long)nums[left++], (long)nums[right--]); 
        }
        return concatenatedValue;
    }
    
    private long concatenate(long a, long b) {
        int digitCountB = (int)Math.floor(Math.log10(b)) + 1;
        long power10 = (long)Math.pow(10, digitCountB);
        return a * power10 + b;
    }
}