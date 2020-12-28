package labuladong.mustread;

import java.util.HashMap;
import java.util.Map;

public class ChangeCoins {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] coins = new int[]{1, 2, 5, 10, 20, 50};
        int count = solution.coinChange(coins, 92);
        System.out.println("count = " + count);
    }

    static class Solution {

        public int coinChange(int[] coins, int amount) {
            if (amount < 0) return -1;
            if (amount == 0) return 0;
            return coinChange(coins, amount, new int[amount]);
        }

        public int coinChange(int[] coins, int amount, int[] table) {
            if (amount < 0) return -1;
            if (amount == 0) return 0;
            if (table[amount - 1] != 0) return table[amount - 1];
            int count = Integer.MAX_VALUE;
            for (int coin : coins) {
                int rest = amount - coin;
                int deep = coinChange(coins, rest,table);
                if (deep == -1) continue;
                count = Math.min(count, deep + 1);
            }

            int result = count == Integer.MAX_VALUE ? -1 : count;
            table[amount - 1] = result;
            return result;
        }


    }


}


