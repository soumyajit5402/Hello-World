class Solution {
    public int uniquePaths(int m, int n) {
        return getCombinations(m + n - 2, m - 1);
    }
    
    int getCombinations(long a, long b) {
        long ans = 1l, base = Math.min(b, a-b);
        for (long i = 1l; i <= base; i++, a--) ans = (ans * a) / i;
        return (int)ans;
    }
}