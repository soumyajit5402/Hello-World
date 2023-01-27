class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        
        int l = m + n;
        for (int i = l-1; i >= 0; i--) {
            int temp = nums1[i];
            if (m > 0 && n > 0) {
                if (nums1[m-1] > nums2[n-1]) {
                    nums1[i] = nums1[m-1];
                    nums1[--m] = temp;
                } else {
                    nums1[i] = nums2[n-1];
                    nums2[--n] = temp;
                }
            } else if (m == 0) {
                nums1[i] = nums2[n-1];
                nums2[--n] = temp;
            } else if (n == 0) {
                nums1[i] = nums1[m-1];
                nums1[--m] = temp;
            }
        }
    }
}