class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[] arr = new int[numRows];
        Arrays.fill(arr, 1);
        List<List<Integer>> container = new LinkedList<>();
        for (int i = 1; i <= numRows; i++) {
            for (int j = i - 2; j > 0; j--) arr[j] = arr[j] + arr[j - 1];
            List<Integer> curr = new LinkedList<>();
            for (int j = 0; j < i; j++) curr.add(arr[j]);
            container.add(curr);
        }
        return container;
    }
}