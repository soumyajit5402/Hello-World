class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex + 1];
        Arrays.fill(ans, 1);
        
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = (i - 1); j > 0; j--) {
                ans[j] += ans[j - 1];
            }
        }
        
        List<Integer> container = new LinkedList<>();
        for (int num : ans) container.add(num);
        return container;
    }
}