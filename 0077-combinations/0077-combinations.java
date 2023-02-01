class Solution {
    List<List<Integer>> container = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        findCombinations(1, k, n, new ArrayList<>());
        return container;
    }
    
    private void findCombinations(int val, int len, int max, List<Integer> currList) {
        if (currList.size() == len) container.add(currList);
        if (currList.size() >= len || val > max) return;
        
        List<Integer> included = new ArrayList<>(currList);
        included.add(val);
        findCombinations(val + 1, len, max, included);
        List<Integer> excluded = new ArrayList<>(currList);
        findCombinations(val + 1, len, max, excluded);
    }
}