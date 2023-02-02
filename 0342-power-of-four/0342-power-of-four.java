class Solution {
    public boolean isPowerOfFour(int n) {
        // 0x55555555 -> 01010101010101010101010101010101
        // Check if number is a power of 2 and then verify if it's an odd or even bit
        return ((n > 0 && ((n & (n-1)) == 0)) && ((n & 0x55555555) != 0));
    }
}