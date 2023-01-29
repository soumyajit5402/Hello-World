class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long deltaPos = 0l, deltaNeg = 0l, equalCount = 0l;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) continue;
            if (k == 0 || Math.abs(nums1[i] - nums2[i]) % k > 0) return -1l;
            
            if (nums1[i] < nums2[i]) deltaPos += (long)((nums2[i] - nums1[i]) / k);
            else deltaNeg += (long)((nums1[i] - nums2[i]) / k);  
        }
        if (deltaPos == deltaNeg) return deltaPos;
        return -1;
    }
}