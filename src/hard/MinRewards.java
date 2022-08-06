package hard;

public class MinRewards {

    public static void main(String[] args) {
        int[] scores = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        int result = minRewards(scores);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int minRewards(int[] scores) {
        if (scores.length == 1) {
            return scores[0];
        }
        int[] rewards = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            rewards[i] = 1;
        }

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int element : rewards) {
            sum += element;
        }
        return sum;
    }

    // O(n^2) time | O(n) space
    public static int minRewardsNotOptimal(int[] scores) {
        // Write your code here.
        int[] rewards = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            rewards[i] = 1;
        }
        for (int i = 1; i < scores.length; i++) {
            int j = i - 1;
            if (scores[i] > scores[j]) {
                rewards[i] = rewards[j] + 1;
            } else {
                while (j >= 0 && scores[j] > scores[j + 1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
                    j--;
                }
            }
        }
        int sum = 0;
        for (int element : rewards) {
            sum += element;
        }
        return sum;
    }

}
