/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
package leetcode;

public class LeetCode123BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] prev = new int[len];
        int[] future = new int[len];
        int result = Integer.MIN_VALUE;

        int preMin = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prices[i] < preMin) {
                preMin = prices[i];
            }

            int profit = prices[i] - preMin;

            if (i == 0 || profit > prev[i - 1]) {
                prev[i] = profit;
            } else {
                prev[i] = prev[i - 1];
            }

        }

        int futureMax = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (prices[i] > futureMax) {
                futureMax = prices[i];
            }

            int profit = futureMax - prices[i];

            if (i == len - 1 || profit > future[i + 1]) {
                future[i] = profit;
            } else {
                future[i] = future[i + 1];
            }
        }

        for (int i = 0; i < len; i++) {
            if (prev[i] + future[i] > result) {
                result = prev[i] + future[i];
            }
        }

        return result;
    }
}
