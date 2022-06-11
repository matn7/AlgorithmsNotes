package medium;

public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int[] denoms = {1, 5, 10, 25};
        int n = 10;

        int result = numberOfWaysToMakeChange(n, denoms);
        System.out.println(result);

    }

    // O(Nd) time (d denom) | O(N) space
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n + 1];
        ways[0] = 1;
        // 1 1                          ways
        // 0 1 2 3 4 5 6 7 8 9 10       target amount
        // denom < amount
        for (int i = 0; i < denoms.length; i++) {
            int denom = denoms[i];
            for (int amount = 0; amount < ways.length; amount++) {
                if (denom <= amount) {
                    ways[amount] += ways[amount - denoms[i]];
                }
            }

        }
        return ways[n];
    }

}
