class Solution {
    List<List<Integer>> container = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        findPermutations(nums, 0, new ArrayList<>());
        return container;
    }
    
    private void findPermutations(int[] arr, int index, List<Integer> currList) {
        if (index == arr.length) {
            container.add(currList);
            return;
        }
        
        for (int swapIndex = index; swapIndex < arr.length; swapIndex++) {
            swap(arr, index, swapIndex);
            List<Integer> newList = new ArrayList<>(currList);
            newList.add(arr[index]);
            findPermutations(arr, index + 1, newList);
            swap(arr, index, swapIndex);
        }
    }
    
    private void swap(int[] arr, int pos1, int pos2) {
        if (pos1 < 0 || pos1 >= arr.length || pos2 < 0 || pos2 >= arr.length) return;
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}