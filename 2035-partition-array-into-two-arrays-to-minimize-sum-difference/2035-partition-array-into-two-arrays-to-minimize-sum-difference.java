class Solution {
    public int minimumDifference(int[] nums) {
        Set<Integer>[] containerLeft = new Set[1 + (nums.length >> 1)];
        Set<Integer>[] containerRight = new Set[1 + (nums.length >> 1)];
        
        findAllSums(nums, 0, (nums.length >> 1) - 1, 0, 0, containerLeft);
        findAllSums(nums, (nums.length >> 1), nums.length - 1, 0, 0, containerRight);
        
        // leftSum = a + b
        // rightSum = total - (a + b)
        // rightSum - leftSum = total - 2a - 2b
        // given 'a' and total, b = nearest value to [(total - 2a) / 2]
        int minDiff = Integer.MAX_VALUE;
        int total = Arrays.stream(nums).sum();
        for (int leftLen = 0; leftLen <= nums.length/2; leftLen++) {
            int rightLen = (nums.length/2) - leftLen;
            TreeSet<Integer> rightVals = new TreeSet<>(containerRight[rightLen]);
            for (int val : containerLeft[leftLen]) {
                int delta = ((total - (val << 1)) >> 1);
                Integer floorVal = rightVals.floor(delta);
                if (floorVal != null) minDiff = Math.min(minDiff, Math.abs(total - (val << 1) - (floorVal << 1)));
                Integer ceilingVal = rightVals.ceiling(delta);
                if (ceilingVal != null) minDiff = Math.min(minDiff, Math.abs(total - (val << 1) - (ceilingVal << 1)));
            }
        }
        return minDiff;
    }
    
    private void findAllSums(int[] arr, int left, int right, int count, int sum, Set<Integer>[] container) {
        if (container[count] == null) container[count] = new HashSet<>();
        container[count].add(sum);
        if (left > right) return;
        findAllSums(arr, left + 1, right, count + 1, sum + arr[left], container);
        findAllSums(arr, left + 1, right, count, sum, container);
    }
    
    private int getDiff(int[] arr, int num) {
        int sum1 = 0, sum2 = 0;
        for (int val : arr) {
            if ((num & 1) != 0) sum1 += val;
            else sum2 += val;
            num = num >> 1;
        }
        return Math.abs(sum1 - sum2);
    }
}