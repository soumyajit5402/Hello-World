class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        // store count of characters in magazine
        for (char c : magazine.toCharArray()) count[c - 'a']++;
        // reduce count of characters from ransom note
        for (char c : ransomNote.toCharArray()) {
            // if there are more characters required return false
            if (--count[c - 'a'] < 0) return false;   
        }
        return true;
    }
}