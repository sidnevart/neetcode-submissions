class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int maxProfit = 0;
        for (int r = 1; r < prices.length; r++){
            while (prices[r] < prices[l]){
                l++;
            } 
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            
        }

        return maxProfit;
    }
}
