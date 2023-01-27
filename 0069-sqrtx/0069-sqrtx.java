class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x, max_int_sqrt = 46340; // handle integer overflow
        
        while (high - low > 1) {
            int mid = ((low + high) >> 1);
            if (mid * mid == x) return mid;
            else if (mid * mid > x || mid >= max_int_sqrt) high = mid - 1;
            else low = mid;
        }
        return (high * high <= x) ? high : low;
    }
}