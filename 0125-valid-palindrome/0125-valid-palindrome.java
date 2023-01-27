class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' <= 25) sb.append(c + "");
            if (c - '0' >= 0 && c - '0' <= 9) sb.append(c + "");
        }
        
        String str = sb.toString();
        String rev = sb.reverse().toString();
        
        return str.equals(rev);
    }
}