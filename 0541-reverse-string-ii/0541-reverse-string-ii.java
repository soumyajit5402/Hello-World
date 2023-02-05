class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int a = 0; a < s.length();) {
            for (int b = a, c = Math.min(a + k - 1, s.length() - 1); b < c; b++, c--) {
                char x = arr[b];
                arr[b] = arr[c];
                arr[c] = x;
            }
            a += (k * 2);
        }
        return new String(arr);
    }
}