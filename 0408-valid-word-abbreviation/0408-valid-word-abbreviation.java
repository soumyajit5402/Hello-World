class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int num = 0, index = 0;
        char[] abbrArr = abbr.toCharArray();
        char[] wordArr = word.toCharArray();
        
        for (int i = 0; i < abbrArr.length; i++) {
            if (isNumeric(abbrArr[i])) {
                if (num == 0 && abbrArr[i] == '0') return false;
                else num = num * 10 + (abbrArr[i] - '0');
            } else {
                int wordIndex = index + num;
                if (wordIndex >= word.length() || abbrArr[i] != wordArr[wordIndex]) return false;
                else index = wordIndex + 1;
                num = 0;
            }
        }
        return ((index + num) == word.length());
    }
    
    boolean isNumeric(char c) {
        return ((c - '0') >= 0 && (c - '0') <= 9);
    }
}