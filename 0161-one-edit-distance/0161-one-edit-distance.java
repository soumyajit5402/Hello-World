class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == 0) return t.length() == 1;
        if (t.length() == 0) return s.length() == 1;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
            }
        }
        return dp[s.length()][t.length()] == 1;
    }
}

/*
    a
  0 1 
b 1 1
a 2 1
  */