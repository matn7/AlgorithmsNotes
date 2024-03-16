package whiteboard;

import java.util.Arrays;

public class NonConstructibleChange {

    // O(nlog(n)) time | O(1) space
    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        Arrays.sort(coins);

        int sum = 0;

        for (int coin : coins) {
            if (coin > sum + 1) {
                return sum + 1;
            }
            sum += coin;
        }

        return sum + 1;
    }

}
