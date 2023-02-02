class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                answer.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int count = 0;
        int[] ans = new int[answer.size()];
        for (int num : answer) ans[count++] = num;
        return ans;
    }
}