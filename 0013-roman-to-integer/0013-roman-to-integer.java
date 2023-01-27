class Solution {
    public int romanToInt(String s) {
        int number = 0;
        char[] charArr = s.toCharArray();
        
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
        
        Map<Character, Character> exceptions = new HashMap<>();
        exceptions.put('V', 'I');
        exceptions.put('X', 'I');
        exceptions.put('L', 'X');
        exceptions.put('C', 'X');
        exceptions.put('D', 'C');
        exceptions.put('M', 'C');
        
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 'I' || charArr[i] == 'X' || charArr[i] == 'C') {
                if (charArr.length > i+1 && 
                    exceptions.containsKey(charArr[i+1]) && 
                    exceptions.get(charArr[i+1]) == charArr[i]) {
                        number += (charMap.get(charArr[i+1]) - charMap.get(charArr[i]));
                        i++;
                } else {
                    number += charMap.get(charArr[i]);
                }
            } else {
                number += charMap.get(charArr[i]);
            }
        }
        
        return number;
    }
}