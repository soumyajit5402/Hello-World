class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return internalCalc(1/x, -((long)n));
        return internalCalc(x, (long)n);
    }
    
    private double internalCalc(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double powHalf = internalCalc(x, n / 2);
        double pow = powHalf * powHalf;
        if (n % 2 == 1) pow *= x;
        return pow;
    }
}