package whiteboard;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int n = 6;
        int[] denoms = {1, 5};

        numberOfWaysToMakeChange(n, denoms);
    }

    // O(n*d) time (d denom) | O(n) space
    // #2: 12/07/2022
    // rand: 18/07/2022
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }

}
