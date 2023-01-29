class Solution {
    long mod = 1_000_000_007l;
    public int monkeyMove(int n) {
        long ans = pow2(n) - 2l;
        return ans < 0 ? (int)(mod + ans) : (int)ans;
    }
    
    private long pow2(long n) {
        if (n == 1) return 2l;
        long lowerPower = pow2(n / 2);
        long pow = (lowerPower * lowerPower) % mod;
        if (n % 2 == 1) pow = (pow * 2l) % mod;
        return pow;
    }
}