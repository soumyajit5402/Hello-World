class Solution {
    List<List<Integer>> container = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        findPermutations(nums, 0);
        return container;
    }
    
    private void findPermutations(int[] arr, int index) {
        if (index == arr.length) {
            List<Integer> currList = new ArrayList<>();
            for (int num : arr) currList.add(num);
            container.add(currList);
            return;
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int swapIndex = index; swapIndex < arr.length; swapIndex++) {
            swap(arr, index, swapIndex);
            if (visited.add(arr[index])) findPermutations(arr, index + 1);
            swap(arr, index, swapIndex); // backtracking    
        }
    }
    
    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}