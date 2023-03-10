class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int iterator = 0, iterator1 = 0, iterator2 = 0;
        int[][] ans = new int[nums1.length + nums2.length][2];
        while (iterator1 < nums1.length || iterator2 < nums2.length) {
            if (iterator1 < nums1.length && iterator2 < nums2.length) {
                if (nums1[iterator1][0] < nums2[iterator2][0]) {
                    ans[iterator++] = nums1[iterator1++];    
                } else if (nums2[iterator2][0] < nums1[iterator1][0]) {
                    ans[iterator++] = nums2[iterator2++];    
                } else {
                    ans[iterator] = nums1[iterator1++];
                    ans[iterator++][1] += nums2[iterator2++][1];
                }  
            } else if (iterator1 < nums1.length) {
                ans[iterator++] = nums1[iterator1++];
            } else if (iterator2 < nums2.length) {
                ans[iterator++] = nums2[iterator2++];
            }
        }
        return Arrays.copyOfRange(ans, 0, iterator);
    }
}