class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] curr = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) {
                curr = new int[] { Math.min(curr[0], intervals[i][0]), Math.max(curr[1], intervals[i][1]) };
            } else {
                ans.add(curr);
                curr = intervals[i];
            }   
        }
        ans.add(curr);
        
        return ans.toArray(new int[ans.size()][2]);
    }
}