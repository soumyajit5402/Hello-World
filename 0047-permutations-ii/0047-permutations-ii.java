class Solution {
    Set<Long> visited = new HashSet<>();
    List<List<Integer>> container = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        findPermutations(nums, 0l, 0);
        return container;
    }
    
    private void findPermutations(int[] arr, long uniqueKey, int index) {
        if (index == arr.length) {
            if (!visited.contains(uniqueKey)) {
                List<Integer> currList = new ArrayList<>();
                for (int num : arr) currList.add(num);
                container.add(currList);
            }
            visited.add(uniqueKey);
            return;
        }
        
        for (int swapIndex = index; swapIndex < arr.length; swapIndex++) {
            swap(arr, index, swapIndex);
            // compute unique key to avoid duplicates
            long newUniqueKey = uniqueKey * 100l + (arr[index] + 10l); 
            findPermutations(arr, newUniqueKey, index + 1);
            swap(arr, index, swapIndex); // backtracking
        }
    }
    
    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}