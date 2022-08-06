package whiteboard;

import java.util.Arrays;

public class MinRewards {

    public static void main(String[] args) {
        int[] scores = {8, 4, 2, 1, 3, 6, 7, 9, 5};

        minRewards(scores);
    }

    // O(n) time | O(n) space
    // #2: 04/07/2022
    // rand: 01/08/2022
    public static int minRewards(int[] scores) {
        // Write your code here.
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        for (int idx = 1; idx < scores.length; idx++) {
            int currVal = scores[idx];
            int prevVal = scores[idx - 1];
            if (currVal > prevVal) {
                rewards[idx] = rewards[idx - 1] + 1;
            }
        }

        for (int idx = scores.length - 2; idx >= 0; idx--) {
            int currVal = scores[idx];
            int nextVal = scores[idx + 1];
            if (currVal > nextVal) {
                rewards[idx] = Math.max(rewards[idx], rewards[idx + 1] + 1);
            }
        }
        int sum = 0;
        for (int element : rewards) {
            sum += element;
        }
        return sum;
    }

}
