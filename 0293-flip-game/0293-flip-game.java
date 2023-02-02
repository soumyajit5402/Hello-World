class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        char[] arr = currentState.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i+1] == '+') {
                arr[i] = '-';
                arr[i+1] = '-';
                ans.add(new String(arr));
                arr[i] = '+';
                arr[i+1] = '+';
            }
        }
        return ans;
    }
}