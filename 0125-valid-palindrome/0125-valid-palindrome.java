class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            boolean leftEligible = (arr[left]-'a' >= 0 && arr[left]-'a' <= 25) || (arr[left]-'0' >= 0 && arr[left]-'0' <= 9);
            boolean rightEligible = (arr[right]-'a' >= 0 && arr[right]-'a' <= 25) || (arr[right]-'0' >= 0 && arr[right]-'0' <= 9);
            
            if (leftEligible && rightEligible) {
                if (arr[left] != arr[right]) return false;
                right--;
                left++;
            } else if (leftEligible) {
                right--;
            } else if (rightEligible) {
                left++;
            } else {
                right--;
                left++;
            }
        }
        return true;
    }
}