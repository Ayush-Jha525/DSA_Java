//Q.Best Time to Buy and Sell Stock
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class BuySellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int profit = 0;
        int buyDay = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[buyDay] > prices[i]) {
                buyDay = i;
            } else {
                profit = Math.max(profit, prices[i] - prices[buyDay]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 }; // expected output : 2
        System.out.println(maxProfit(prices));
    }
}
