package medium;

public class MinNumberOfCoinsForChange {

    // O(n * d) time (d - denom) | O(n) space
    // OK - repeated 13/02/2022
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.

        //                 $10
        //           1 2 3 $5
        // 0 1 2 3 4 5 6 7 $1
        // _ _ _ _ _ _ _ _
        // 0 1 2 3 4 5 6 7 $
        //             a

        // if denom <= amount:
        //      nums[amount] = min(nums[amount], 1 + nums[amount - denom])

        int[] numOfCoins = new int[n + 1];
        // _ _ _ _ _ _ _ _
        // 0 1 2 3 4 5 6 7
        for (int i = 0; i < numOfCoins.length; i++) {
            numOfCoins[i] = 99999;
        }
        numOfCoins[0] = 0;
        for (int denom : denoms) { // 1
            for (int amount = 0; amount < numOfCoins.length; amount++) {
                if (denom <= amount) { // 5 <= 7
                    // min(7, 1 + 2) = 3
                    numOfCoins[amount] = Math.min(numOfCoins[amount], 1 + numOfCoins[amount - denom]);
                }
            }
        }

        return numOfCoins[n] != 99999 ? numOfCoins[n] : -1;
    }

}
