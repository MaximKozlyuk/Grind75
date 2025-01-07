package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    /**
     * https://leetcode.com/problems/coin-change/description/
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return doActualChange(coins, amount, memo);
    }

    private int doActualChange(int[] coins, int remaining, Map<Integer, Integer> memo) {
        if (remaining == 0) {
            return 0;
        }
        if (remaining < 0) {
            return -1;
        }
        if (memo.containsKey(remaining)) {
            return memo.get(remaining);
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = doActualChange(coins, remaining - coin, memo);
            if (result >= 0) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        memo.put(remaining, minCoins == Integer.MAX_VALUE ? -1 : minCoins);
        return memo.get(remaining);
    }

}
