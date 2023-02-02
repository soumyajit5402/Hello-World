class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num, max_int_sqrt = 46340;
        while (high - low > 1) {
            int mid = low + high >> 1;
            if (mid * mid == num) return true;
            else if (mid * mid > num || mid >= max_int_sqrt) high = mid - 1;
            else low = mid + 1;
        }
        
        if (high * high == num || low * low == num) return true;
        return false;
    }
}