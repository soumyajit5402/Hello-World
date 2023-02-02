class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> container1 = new HashSet<>();
        for (int i : nums1) container1.add(i);
        
        Set<Integer> container2 = new HashSet<>();
        for (int i : nums2) container2.add(i);
        
        container1.retainAll(container2); // set intersection

        int count = 0;
        int[] ans = new int[container1.size()];
        for (int i : container1) ans[count++] = i;
        return ans;
    }
}