package whiteboard;

public class NumberOfWaysToMakeAChangeRanmd {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        if (denoms.length == 0 || n < 0) {
            return 0;
        }

        int[] ways = new int[n + 1];
        ways[0] = 1;

        for (int denom : denoms) {
            for (int amount = 1; amount < n; amount++) {
                if (amount >= denom) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }

        return ways[n];
    }

}
