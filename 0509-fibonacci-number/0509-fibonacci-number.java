class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int x = 0, y = 1;
        for (int i = 2; i <= n; i++) {
            int curr = x + y;
            x = y;
            y = curr;
        }
        return y;
    }
}