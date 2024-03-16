package medium;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int[] denoms = {1, 5, 10, 25};

        int result = numberOfWaysToMakeChange(10, denoms);
        System.out.println(result);
    }

    // O(n*d) time (d denom) | O(n) space
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n + 1];
        ways[0] = 1;

        // denoms = [1, 5, 10, 25]
        //            a
        // ways = [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 4]
        // amount  0  1  2  3  4  5  6  7  8  9  10
        for (int denom : denoms) {
            // denom = 10
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) { // 5 <= 10
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }

}
