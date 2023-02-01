class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int min = 0, max = (1 << nums.length);
        List<List<Integer>> container = new ArrayList<>();
        for (int i = min; i < max; i++) container.add(findSet(i, nums));
        return container;
    }
    
    private List<Integer> findSet(int val, int[] arr) {
        List<Integer> currList = new ArrayList<>();
        int index = 0;
        while (val > 0) {
            if ((val & 1) != 0) currList.add(arr[index]);
            val = val >> 1;
            index++;
        }
        return currList;
    }
}