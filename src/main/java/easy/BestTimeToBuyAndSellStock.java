package easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(
                maxProfit(
                        new int[]{7, 1, 5, 3, 6, 4}
                )  // expected 5
        );
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     */
    static public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0];
        int maxDelta = 0;
        for (int i = 0; i < prices.length; i++) {
            var currentDelta = prices[i] - minPrice;
            if (currentDelta > maxDelta) {
                maxDelta = currentDelta;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxDelta;
    }

    static public int maxProfit_BRUTEFORCE(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxDelta = 0;
        for (int low = 0; low < prices.length; low++) {
            if (low == prices.length - 1) {
                break;
            }
            for (int high = low + 1; high < prices.length; high++) {
                var currentDelta = prices[high] - prices[low];
                if (maxDelta < currentDelta) {
                    maxDelta = currentDelta;
                }
            }
        }
        return maxDelta;
    }

}
