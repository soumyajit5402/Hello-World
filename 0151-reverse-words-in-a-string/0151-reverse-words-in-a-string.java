class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] tokens = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (tokens[i].length() > 0) {
                if (ans.length() > 0) ans.append(" ");
                ans.append(tokens[i]);
            }
        }
        return ans.toString();
    }
}