class Solution {
    Set<Long> visited = new HashSet<>();
    List<List<Integer>> container = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        findPermutations(nums, 0, 0l, new ArrayList<>());
        return container;
    }
    
    private void findPermutations(int[] arr, int index, long uniqueKey, List<Integer> currList) {
        if (index == arr.length) {
            if (!visited.contains(uniqueKey)) container.add(currList);
            visited.add(uniqueKey);
            return;
        }
        
        for (int swapIndex = index; swapIndex < arr.length; swapIndex++) {
            swap(arr, index, swapIndex);
            List<Integer> newList = new ArrayList<>(currList);
            newList.add(arr[index]);
            // compute unique key to avoid duplicates
            long newUniqueKey = uniqueKey * 100l + (arr[index] + 10l); 
            findPermutations(arr, index + 1, newUniqueKey, newList);
            swap(arr, index, swapIndex); // backtracking
        }
    }
    
    private void swap(int[] arr, int pos1, int pos2) {
        if (pos1 < 0 || pos1 >= arr.length || pos2 < 0 || pos2 >= arr.length) return;
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}