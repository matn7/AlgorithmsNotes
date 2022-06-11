package easy;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        NonConstructibleChange nonConstructibleChange = new NonConstructibleChange();
        nonConstructibleChange.nonConstructibleChange(coins);
    }

    // OK - repeated 05/03/2022
    // rec([5, 7, 1, 1, 2, 3, 22])
    // O(nlog(n)) time | O(1) space
    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        // [5, 7, 1, 1, 2, 3, 22]
        Arrays.sort(coins);
        //                 c
        // [1, 1, 2, 3, 5, 7, 22]
        int currentChangeCreated = 0;
        for (int coin : coins) {
            if (coin > currentChangeCreated + 1) { // 22 > 20
                return currentChangeCreated + 1; // 20
            }
            currentChangeCreated += coin; // 19
        }

        return currentChangeCreated + 1;
    }

}
