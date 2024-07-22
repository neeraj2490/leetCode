class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] number = new int[amount + 1];

        for(int i = 0; i <= amount; i++) {
            number[i] = -2;
        }

        return change(coins, amount, number);
    }

    private int change(int[] coins, int amount, int[] number) {

        if(amount == 0) {
            return 0;
        }

        else if(amount < 0) {
            return -1;
        }

        else if(number[amount] != -2) {
            return number[amount];
        }

        else {
            int minCoins = Integer.MAX_VALUE;
            int len = coins.length;

            for(int i = 0; i < len; i++) {
                int numberOfCoins = change(coins, amount - coins[i], number);
                numberOfCoins = numberOfCoins == -1 ? -1 : numberOfCoins + 1;

                if(numberOfCoins != -1 && numberOfCoins < minCoins) {
                    minCoins = numberOfCoins;
                }
            }

            number[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
            return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        }
    }
}
