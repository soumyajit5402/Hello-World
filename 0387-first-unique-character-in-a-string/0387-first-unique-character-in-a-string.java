class Solution {
    public int firstUniqChar(String s) {
        int[] store = new int[26];
        Arrays.fill(store, -1);
        for (int i = 0; i < s.length(); i++) {
            if (store[s.charAt(i) - 'a'] >= 0) store[s.charAt(i) - 'a'] = -2; // represents duplicates
            if (store[s.charAt(i) - 'a'] == -1) store[s.charAt(i) - 'a'] = i;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (store[i] >= 0) min = Math.min(min, store[i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}