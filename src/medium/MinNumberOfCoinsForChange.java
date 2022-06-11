package medium;

public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {
        int[] denoms = {2, 4};
        int n = 7;

        int result = minNumberOfCoinsForChange(n, denoms);
        System.out.println(result);
    }

    // O(Nd) time | O(N) space
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] numOfCoins = new int[n + 1];
        for (int amount = 0; amount < numOfCoins.length; amount++) {
            numOfCoins[amount] = 9999;
        }
        numOfCoins[0] = 0;

        for (int i = 0; i < denoms.length; i++) {
            int denom = denoms[i];
            for (int amount = 0; amount < numOfCoins.length; amount++) {
                if (denom <= amount) {
                    numOfCoins[amount] = Math.min(numOfCoins[amount], 1 + numOfCoins[amount - denom]);
                }
            }
        }

        if (numOfCoins[n] == 9999) {
            return -1;
        }

        return numOfCoins[n];
    }

}
