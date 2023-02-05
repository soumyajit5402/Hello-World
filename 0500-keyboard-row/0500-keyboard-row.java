class Solution {
    public String[] findWords(String[] words) {
        String[] keyboard = new String[] { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        Map<Character, Integer> container = new HashMap<>();
        for (int index = 0; index < 3; index++) {
            for (char c : keyboard[index].toCharArray()) {
                // add mapping of lowercase characters to keyboard row
                container.put(c, (index + 1)); 
                // add mapping of uppercase characters to keyboard row
                container.put((char)(c - 'a' + 'A'), (index + 1));
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            // check if all characters in word are from same row and add it to answer
            boolean allCharsFromSameRow = true;
            char[] arr = word.toCharArray();
            for (int i = 1; i < word.length(); i++) {
                if (container.get(arr[i]) != container.get(arr[0])) {
                    allCharsFromSameRow = false;
                    break;
                }
            }
            if (allCharsFromSameRow) ans.add(word);
        }
        
        // form answer array and return
        String[] ansArr = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) ansArr[i] = ans.get(i);
        return ansArr;
    }
}