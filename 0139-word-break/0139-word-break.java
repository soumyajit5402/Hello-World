class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        checkWordBreak(s, 0, wordDict, dp);
        return dp[0] == 1;
    }
    
    private boolean checkWordBreak(String s, int index, List<String> wordDict, int[] dp) {
        if (index == s.length()) return true;
        if (dp[index] != 0) return dp[index] == 1;
        String newWord = s.substring(index);
        for (String word : wordDict) {
            if (newWord.startsWith(word) && checkWordBreak(s, index + word.length(), wordDict, dp)) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = -1;
        return false;
    }
}