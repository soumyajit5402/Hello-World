class Solution {
    List<List<Integer>> container = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        findCombinations(1, k, n, new LinkedList<>());
        return container;
    }
    
    private void findCombinations(int val, int len, int max, LinkedList<Integer> currList) {
        if (currList.size() == len) container.add(new LinkedList<>(currList));
        if (currList.size() >= len || val > max) return;
        
        currList.add(val);
        findCombinations(val + 1, len, max, currList);
        currList.removeLast();
        findCombinations(val + 1, len, max, currList);
    }
}