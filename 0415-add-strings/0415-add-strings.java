class Solution {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        char[] ans = new char[Math.max(arr1.length, arr2.length) + 1];
        
        int carry = 0;
        // start addition from right end (least significant digit) and maintain a carry
        for (int i = arr1.length-1, j = arr2.length-1, k = ans.length-1; k >= 0; i--, j--, k--) {
            if (i >= 0) carry += (arr1[i] - '0');
            if (j >= 0) carry += (arr2[j] - '0');
            ans[k] = (char)(carry % 10 + '0');
            carry /= 10;
        }
        
        String answer = new String(ans);
        // trim any trailing zeros to the left
        if (answer.charAt(0) == '0' && answer.length() > 1) return answer.substring(1);
        return answer;
    }
}