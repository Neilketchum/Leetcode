package SlidingWindow;
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BuySellStock {
    public static int maxProfitBrute(int[] prices) {
                    int profit = Integer.MIN_VALUE;
                    for (int i =0;i< prices.length;i++){
                        for(int j = i + 1;j<prices.length;j++){
                            profit = Math.max(profit,prices[j] - prices[i]);
                        }
                    }
                    return Math.max(profit, 0);
    }
    public static int maxProfitSlidingWindow(int[] prices) {
        int profit = Integer.MIN_VALUE;
        if(prices.length <=1){
            return 0;
        }
        int buyPrice = 0;
        int sellPrice = 1;
        for (int i = 1; i < prices.length ; i++) {
            sellPrice = i;
            if(prices[i] < prices[buyPrice]){
                System.out.println("44 " + profit);
                buyPrice = i;
            }else{
                profit = Math.max(profit,prices[sellPrice]- prices[buyPrice]);
            }
        }
        return Math.max(profit,0);
    }
    public static void main(String[] args) {
        System.out.println(maxProfitSlidingWindow(new int[]{7,1,5,3,6,4}));
    }
}
