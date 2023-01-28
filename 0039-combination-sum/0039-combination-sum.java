class Solution {
    List<List<Integer>> container = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getCombinations(candidates, 0, 0, target, new ArrayList<>());
        return container;
    }
    
    private void getCombinations(int[] arr, int index, int sum, int target, List<Integer> currList) {
        if (sum == target) container.add(currList);
        if (sum >= target || index >= arr.length) return;
        
        while(sum <= target) {
            List<Integer> newList = new ArrayList<>(currList);
            getCombinations(arr, index + 1, sum, target, newList);
            currList.add(arr[index]);
            sum += arr[index];
        }
    }
}