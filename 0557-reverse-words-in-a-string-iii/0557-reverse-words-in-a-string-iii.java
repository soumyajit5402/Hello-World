class Solution {
    public String reverseWords(String s) {
        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(reverse(token.toCharArray()));
        }
        return sb.toString();
    }
    
    String reverse(char[] arr) {
        int i = -1, j = arr.length;
        while (++i < --j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
        return new String(arr);
    }
}