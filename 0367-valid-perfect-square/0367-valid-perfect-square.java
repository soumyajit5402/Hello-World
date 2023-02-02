class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i = 2; i <= Math.min(1 << 15, num); i++) {
            while (num % (i * i) == 0) {
                num = num / (i * i); 
            }
        }
        return num == 1;
    }
}