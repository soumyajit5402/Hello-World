class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] tokens = s.split(" ");
        char[] arr = pattern.toCharArray();
        if (tokens.length != arr.length) return false;
        
        Map<Character, String> charToStr = new HashMap<>();
        Map<String, Character> strToChar = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (charToStr.containsKey(arr[i]) && !charToStr.get(arr[i]).equals(tokens[i])) return false;
            if (strToChar.containsKey(tokens[i]) && strToChar.get(tokens[i]) != arr[i]) return false;
            charToStr.put(arr[i], tokens[i]);
            strToChar.put(tokens[i], arr[i]);
        }
        return true;
    }
}