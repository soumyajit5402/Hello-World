class Solution {
    int[] dp;
    List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        dp = new int[s.length()];
        checkWordBreak(s, 0);
        return dp[0] == 1;
    }
    
    private boolean checkWordBreak(String s, int index) {
        if (index == s.length()) return true;
        if (dp[index] != 0) return dp[index] == 1;
        String newWord = s.substring(index);
        for (String word : wordDict) {
            if (newWord.startsWith(word) && checkWordBreak(s, index + word.length())) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = -1;
        return false;
    }
}