class Solution {
    public boolean isReachable(int targetX, int targetY) {
        /*
        Lee Solution:
        
        Intuition
            Try go from (x, y) to (1,1)
            Consider the reverse operation of
            (x, y - x)
            (x - y, y)
            (2 * x, y)
            (x, 2 * y)

            that is
            (x, y + x)
            (x + y, y)
            (x / 2, y) if x % 2 == 0
            (x, y / 2) if y % 2 == 0

        Necessary Condition
            Assume x and y have a common divisor v bigger than 2,
            Since
            (x + y) % v == 0
            (x / 2) % v == 0 if x is even
            (y / 2) % v == 0 if y is even
            The new value always can be divided by v

            No matter what operation we use,
            we can't reach (1,1)

            To go from (x,y) to (1,1),
            we have the necessary condition :
            gcd(x,y) = 2 ^ k

        Sufficient Condition
            Assume gcd(x,y) = 2 ^ k
            If x is even, we can go (x / 2, y)
            If y is even, we can go (x, y / 2)
            If both odd and x < y, we can go (x, (x+y)/2)
            If both odd and x > y, we can go ((x+y)/2, y)
            (x, y) can continue go smaller,
            until (x, y) both odd and x == y,
            that is x == y == 1

        Conclusion
            Based on the Necessary Condition and Sufficient Condition,
            we conclude that
            "(1, 1) can go forward to (x, y)"
            equals to
            "(x, y) can go back to (1, 1)"
            equals
            gcd(x,y) is pow of 2.
        */
        
        int gcd = getGCD(targetX, targetY);
        return ((gcd & (gcd - 1)) == 0);   
    }
                
    private int getGCD(int x, int y) {
        if (x < y) return getGCD(y, x);
        if (x % y == 0) return y;
        return getGCD(x - y, y);
    }                
}