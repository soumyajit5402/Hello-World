class Solution {
    public boolean detectCapitalUse(String word) {
        return 
            word.equals(getSentenceCase(word)) ||
            word.equals(word.toUpperCase()) || 
            word.equals(word.toLowerCase());
    }

    private String getSentenceCase(String input) {
        char[] arr = input.toLowerCase().toCharArray();
        arr[0] = (char) (arr[0] - 32);
        return new String(arr);
    }
}