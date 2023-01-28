class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] charArrS = s.toCharArray();
        char[] charArrT = t.toCharArray();
        
        Map<Character, Character> charMapST = new HashMap();
        Map<Character, Character> charMapTS = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (charMapST.containsKey(charArrS[i]) && charMapST.get(charArrS[i]) != charArrT[i]) return false;
            if (charMapTS.containsKey(charArrT[i]) && charMapTS.get(charArrT[i]) != charArrS[i]) return false;
            charMapST.put(charArrS[i], charArrT[i]);
            charMapTS.put(charArrT[i], charArrS[i]);
        }
        
        return true;
    }
}