class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        boolean all0 = true;
        int carry = 1;
        for (int x = len-1; x >= 0; x--) {
            int newNum = digits[x] + carry;
            digits[x] = newNum % 10;
            carry = newNum / 10;
            
            all0 &= digits[x]==0;
        }
        
        if (all0) {
            digits = new int[len+1];
            digits[0] = 1;
        }
        
        return digits;
    }
}