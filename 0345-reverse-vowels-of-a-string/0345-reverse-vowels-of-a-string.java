class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (isVowel(arr[i]) && isVowel(arr[j])) {
                char temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            } else if (!isVowel(arr[i])) {
                i++;
            } else if (!isVowel(arr[j])) {
                j--;
            }
        }
        return new String(arr);
    }
    
    boolean isVowel(char c) {
        return ((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ||
                (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'));
    }
}