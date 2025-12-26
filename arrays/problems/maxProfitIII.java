class Solution {

    /*
      Best Time to Buy and Sell Stock III — State Machine Approach (Optimal Solution)

      Approach:
      - We are allowed at most two transactions (buy → sell).
      - Track four states while iterating through prices:
            • buy1  → maximum profit after first buy
            • sell1 → maximum profit after first sell
            • buy2  → maximum profit after second buy
            • sell2 → maximum profit after second sell
      - Each state depends on the previous states and current price.
      - Update states greedily to always keep the best possible outcome.

      State Meaning:
      - buy1  = max profit after buying first stock
      - sell1 = max profit after selling first stock
      - buy2  = max profit after buying second stock
      - sell2 = max profit after selling second stock

      Time  : O(n) — single pass through prices
      Space : O(1) — constant extra space

      Note:
      This is the most optimal solution for at most two transactions.
    */

    public int maxProfit(int[] prices) {

        // Initialize states
        int buy1 = Integer.MIN_VALUE;   // Profit after first buy
        int sell1 = 0;                  // Profit after first sell
        int buy2 = Integer.MIN_VALUE;   // Profit after second buy
        int sell2 = 0;                  // Profit after second sell

        for (int price : prices) {

            // Max profit after first buy (buy at lowest price)
            buy1 = Math.max(buy1, -price);

            // Max profit after first sell
            sell1 = Math.max(sell1, buy1 + price);

            // Max profit after second buy using profit from first sell
            buy2 = Math.max(buy2, sell1 - price);

            // Max profit after second sell
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
