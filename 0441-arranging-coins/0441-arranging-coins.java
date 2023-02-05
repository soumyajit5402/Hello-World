class Solution {
    public int arrangeCoins(int n) {
        // equation = (ans * (ans + 1)) / 2 = n
        // x^2 + x - 2n = 0
        // x = (-1 +- sqrt(1^2 + 4*2n*1)) / (2*1)
        return ((int)Math.sqrt(1l + 8l * n) - 1) >> 1;
    }
}