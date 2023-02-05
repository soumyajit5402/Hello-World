class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLeft = 0, tLeft = 0;
        while (sLeft < s.length() && tLeft < t.length()) {
            if (s.charAt(sLeft) == t.charAt(tLeft)) sLeft++;
            tLeft++;
        }
        return sLeft == s.length();
    }
}