package com.interviewprep.slidingwindow;

public class Stock {

    /**
     * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
     *
     * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
     *
     * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
     *
     *
     * Input: prices = [10,1,5,6,7,1]
     *
     * Output: 6
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Stock stock = new Stock();
        System.out.println(stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
