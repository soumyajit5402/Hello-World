class Solution {
    public int lengthOfLongestSubstring(String s) {
        int currLength = 0, maxLength = 0, start = 0;
        Map<Character, Integer> charLocationMap = new HashMap<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            if (charLocationMap.getOrDefault(c, -1) >= start) {
                currLength = i - charLocationMap.get(c);
                start = charLocationMap.get(c) + 1;
            } else {
                currLength++; 
            }
            
            charLocationMap.put(c, i);
            maxLength = Math.max(currLength, maxLength);
        }
        
        return maxLength;
    }
}