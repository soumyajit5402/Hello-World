class Solution {
    public int percentageLetter(String s, char letter) {
        int total = s.length(), count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) count++;
        }
        return (int)Math.round((100 * count) / total);
    }
}