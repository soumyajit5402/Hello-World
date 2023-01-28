class Solution {
    List<String> result = new ArrayList<>();
    Map<Integer, char[]> container = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return result;
        
        container.put(2, new char[] { 'a', 'b', 'c' });
        container.put(3, new char[] { 'd', 'e', 'f' });
        container.put(4, new char[] { 'g', 'h', 'i' });
        container.put(5, new char[] { 'j', 'k', 'l' });
        container.put(6, new char[] { 'm', 'n', 'o' });
        container.put(7, new char[] { 'p', 'q', 'r', 's' });
        container.put(8, new char[] { 't', 'u', 'v' });
        container.put(9, new char[] { 'w', 'x', 'y', 'z' });
        
        getCombinations(digits.toCharArray(), 0, new StringBuilder());
        return result;
    }
    
    private void getCombinations(char[] arr, int index, StringBuilder sb) {
        if (index == arr.length) {
            result.add(sb.toString());
            return;
        }
        
        for (char c : container.get(arr[index] - '0')) {
            StringBuilder sbNew = new StringBuilder(sb.toString()).append(c + "");
            getCombinations(arr, index + 1, sbNew);
        }
    }
}