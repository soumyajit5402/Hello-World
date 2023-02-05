class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int xor = (tArr[t.length()-1] - 'a');
        for (int i = 0; i < s.length(); i++) {
            xor = xor ^ (sArr[i] - 'a');
            xor = xor ^ (tArr[i] - 'a');
        }
        return (char)(xor + 'a');
    }
}