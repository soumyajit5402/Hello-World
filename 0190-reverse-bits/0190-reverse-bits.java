public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            int curr = n & 1;
            n = n >> 1;
            ans |= curr << (31 - i);
        }
        return ans;
    }
}