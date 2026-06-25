class Solution {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}