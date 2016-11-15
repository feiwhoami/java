/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
package leetcode;

public class LeetCode188BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {

        if (null == prices || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        if (k >= len) {
            return moreTransaction(prices);
        }

        int[][] local = new int[len + 1][k + 1];
        int[][] global = new int[len + 1][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[len - 1][k];
    }

    private int moreTransaction(int[] prices) {

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                result = result + prices[i] - prices[i - 1];
            }
        }
        return result;
    }

}
