package whiteboard;

import java.util.Arrays;

public class MinRewards2 {
    // O(n) time | O(n) space
    public static int minRewards(int[] scores) {
        // Write your code here.
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]){
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int reward : rewards) {
            sum += reward;
        }
        return sum;
    }
}
