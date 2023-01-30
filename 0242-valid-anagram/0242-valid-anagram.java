class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null) return false;
        else if (s.length() != t.length()) return false;
        
        int[][] countChars = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            countChars[s.charAt(i) - 'a'][0]++;
            countChars[t.charAt(i) - 'a'][1]++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (countChars[i][0] != countChars[i][1]) return false;
        }
        return true;
    }
}