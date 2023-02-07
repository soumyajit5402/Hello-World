class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean seen1 = false;
        int count = 0, streak = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (seen1) {
                    count += streak > 0 ? ((streak - 1) >> 1) : 0;    
                } else {
                    count += streak > 0 ? (streak >> 1) : 0;    
                }
                seen1 = true;
                streak = 0;
            } else {
                streak++;
            }
        }
        if (seen1) {
            count += streak > 0 ? (streak >> 1) : 0;    
        } else {
            count += streak > 0 ? ((streak + 1) >> 1) : 0;    
        }
        return count >= n;
    }
}