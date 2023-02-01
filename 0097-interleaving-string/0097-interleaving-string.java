class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        dp = new int[s1.length() + 1][s2.length() + 1];
        return checkIsInterleaving(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean checkIsInterleaving(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i1 == s1.length() && i2 == s2.length()) return true;
        if (dp[i1][i2] != 0) return dp[i1][i2] == 1;
        
        boolean result = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) 
            result = result || checkIsInterleaving(s1, i1 + 1, s2, i2, s3, i3 + 1);
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) 
            result = result || checkIsInterleaving(s1, i1, s2, i2 + 1, s3, i3 + 1);
        
        dp[i1][i2] = result ? 1 : -1;
        return dp[i1][i2] == 1;
    }
}