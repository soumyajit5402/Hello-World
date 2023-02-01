class Solution {
    public int numDecodings(String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') != 0) {
                ans[i] += (i >= 1) ? ans[i-1] : 1;
            }
            if (i >= 1) {
                if ((s.charAt(i-1) - '0') != 0) {
                    if (((s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0')) <= 26) {
                        ans[i] += (i >= 2) ? ans[i-2] : 1;    
                    }
                }    
            }
        }
        return ans[s.length() - 1];
    }
}