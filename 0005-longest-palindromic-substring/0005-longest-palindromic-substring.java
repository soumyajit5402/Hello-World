class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int index = 0; index < s.length(); index++) {
            String temp1 = checkPalindrome(s, index, index);
            if (temp1.length() > ans.length()) ans = temp1;
            String temp2 = checkPalindrome(s, index - 1, index);
            if (temp2.length() > ans.length()) ans = temp2;
        }
        return ans;
    }
    
    private String checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            right++;
            left--;
        }
        return s.substring(left + 1, right);
    }
}