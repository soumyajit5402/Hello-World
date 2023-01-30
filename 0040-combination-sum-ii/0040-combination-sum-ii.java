class Solution {
    List<List<Integer>> container = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombinations(candidates, 0, 0, target, new ArrayList<>());
        return container;
    }
    
    private void findCombinations(int[] arr, int index, int sum, int target, List<Integer> currList) {
        if (sum == target) container.add(currList);
        if (sum >= target || index >= arr.length) return;
        
        List<Integer> newListInclude = new ArrayList<>(currList);
        newListInclude.add(arr[index]);
        findCombinations(arr, index + 1, sum + arr[index], target, newListInclude);
        
        List<Integer> newListExclude = new ArrayList<>(currList);
        // skip the same value at the same location to avoid duplicates
        int skipIndex = index + 1;
        for (; skipIndex < arr.length; skipIndex++) if (arr[skipIndex] != arr[index]) break;
        findCombinations(arr, skipIndex, sum, target, newListExclude);
    }
}