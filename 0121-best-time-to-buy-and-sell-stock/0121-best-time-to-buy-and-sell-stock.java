class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, len = prices.length, priceMax = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            int currProfit = priceMax - prices[i];
            maxProfit = Math.max(maxProfit, currProfit);
            priceMax = Math.max(priceMax, prices[i]);
        }
        
        return maxProfit;
    }
}