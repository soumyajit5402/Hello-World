class Solution {
    List<List<String>> container = new ArrayList<>();
    public List<List<String>> partition(String s) {
        palindromePartition(s, 0, 0, new LinkedList<>());
        return container;
    }
    
    private void palindromePartition(String s, int start, int end, LinkedList<String> currList) {
        if (start == end && end == s.length()) container.add(new ArrayList<>(currList));
        if (end >= s.length()) return;
        
        String currString = s.substring(start, end + 1);
        if (isPalindrome(currString)) {
            currList.add(currString);
            palindromePartition(s, end + 1, end + 1, currList);
            currList.removeLast();
        }
        palindromePartition(s, start, end + 1, currList);
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}