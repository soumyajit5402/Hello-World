class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> container = new Stack<>();
        container.push(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (isOverlappingInterval(container.peek(), intervals[i])) {
                int[] mergedInterval = mergeIntervals(container.pop(), intervals[i]);
                container.push(mergedInterval);
            } else {
                container.push(intervals[i]);
            }
        }
        
        int index = container.size() - 1;
        int[][] result = new int[container.size()][2];
        while (!container.isEmpty()) {
            result[index--] = container.pop();
        }
        return result;
    }
    
    private boolean isOverlappingInterval(int[] arr1, int[] arr2) {
        return arr1[1] >= arr2[0];
    }
    
    private int[] mergeIntervals(int[] arr1, int[] arr2) {
        return new int[] { Math.min(arr1[0], arr2[0]), Math.max(arr1[1], arr2[1]) };
    }
}