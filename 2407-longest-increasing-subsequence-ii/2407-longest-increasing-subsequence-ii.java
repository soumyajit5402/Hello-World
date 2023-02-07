class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int maxLISLen = 1;
        int segTreeLen = 1 + Arrays.stream(nums).max().getAsInt();
        MaxSegmentTree maxLISSegmentTree = new MaxSegmentTree(segTreeLen);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                maxLISSegmentTree.updateTree(1, 1);
            } else {
                int left = Math.max(1, nums[i] - k);
                int right = nums[i] - 1;
                int maxInRange = maxLISSegmentTree.getMax(left, right);
                maxLISSegmentTree.updateTree(nums[i], maxInRange + 1);
                maxLISLen = Math.max(maxLISLen, maxInRange + 1);    
            }
        }
        return maxLISLen;
    }
    
    class MaxSegmentTree {
    
        int len;
        int[] arr;

        public MaxSegmentTree(int size) {
            len = size;
            arr = new int[4 * size];
        }

        private void updateTreeUtil(int startIndex, int endIndex, int updateIndex, int newValue, int segTreeIndex) {
            if (updateIndex < startIndex || updateIndex > endIndex) {
                return;
            }

            int midIndex = startIndex + ((endIndex - startIndex) >> 1);
            arr[segTreeIndex] = Math.max(arr[segTreeIndex], newValue);

            if (startIndex == endIndex) return;

            updateTreeUtil(startIndex, midIndex, updateIndex, newValue, 2 * segTreeIndex);
            updateTreeUtil(midIndex + 1, endIndex, updateIndex, newValue, 2 * segTreeIndex + 1);
        }

        public void updateTree(int index, int newValue) {
            updateTreeUtil(0, len - 1, index, newValue, 1);
        }

        private int getMaxUtil(int startIndex, int endIndex, int queryStartIndex, int queryEndIndex, int segTreeIndex) {
            if (queryStartIndex <= startIndex && queryEndIndex >= endIndex) {
                return arr[segTreeIndex];
            }

            if (queryEndIndex < startIndex || queryStartIndex > endIndex) {
                return 0;
            }

            int midIndex = startIndex + ((endIndex - startIndex) >> 1);

            return Math.max(getMaxUtil(startIndex, midIndex, queryStartIndex, queryEndIndex, 2 * segTreeIndex),
                            getMaxUtil(midIndex + 1, endIndex, queryStartIndex, queryEndIndex, 2 * segTreeIndex + 1));
        }                               

        public int getMax(int queryStartIndex, int queryEndIndex) {
            return getMaxUtil(0, len - 1, queryStartIndex, queryEndIndex, 1);
        }
    }
}