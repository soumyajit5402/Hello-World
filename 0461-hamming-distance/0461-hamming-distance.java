class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            // compare last bit of x with last bit of y
            if ((x & 1) != (y & 1)) count++;
            x = x >> 1; // right shift x by 1
            y = y >> 1; // right shift y by 1
        }
        return count;
    }
}