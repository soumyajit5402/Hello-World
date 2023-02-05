class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean[][] subsequenceDP = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (i == 0 && j == 0) subsequenceDP[i][j] = true;
                else if (i == 0) subsequenceDP[i][j] = true;
                else if (j == 0) subsequenceDP[i][j] = false;
                else if (s.charAt(i-1) == t.charAt(j-1)) subsequenceDP[i][j] = subsequenceDP[i-1][j-1];
                else subsequenceDP[i][j] = subsequenceDP[i][j-1]; 
            }
        }
        return subsequenceDP[s.length()][t.length()];
    }
}