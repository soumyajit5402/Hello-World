class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : +1;
        long num = Math.abs(x), rev = 0l;
        while (num != 0) {
            rev = rev * 10l + num % 10l;
            num = num / 10l;
        }
        
        rev = rev * sign;
        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) return 0;
        return (int) rev;
    }
}