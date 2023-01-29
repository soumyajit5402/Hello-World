class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int gcd = getGCD(targetX, targetY);
        return ((gcd & (gcd - 1)) == 0);   
    }
                
    private int getGCD(int x, int y) {
        if (x < y) return getGCD(y, x);
        if (x % y == 0) return y;
        return getGCD(x - y, y);
    }                
}