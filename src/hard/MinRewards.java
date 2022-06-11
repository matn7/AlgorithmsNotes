package hard;

import java.util.ArrayList;
import java.util.List;

public class MinRewards {

    public static void main(String[] args) {
        int[] scores = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        int result = minRewardsLocalMins(scores);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static int minRewards(int[] scores) {
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

    // O(n) time | O(n) space
    public static int minRewardsLocalMins(int[] scores) {
        // Write your code here.
        int[] rewards = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            rewards[i] = 1;
        }

        List<Integer> localMinIdxs = getLocalMinIdx(scores);

        for (Integer localMinIdx : localMinIdxs) {
            expandFromLocalMinIdx(localMinIdx, scores, rewards);
        }

        int sum = 0;
        for (int element : rewards) {
            sum += element;
        }
        return sum;
    }

    private static void expandFromLocalMinIdx(Integer localMinIdx, int[] scores, int[] rewards) {
        int leftIdx = localMinIdx - 1;
        while (leftIdx >= 0 && scores[leftIdx] > scores[leftIdx + 1]) {
            rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx + 1] + 1);
            leftIdx--;
        }
        int rightIdx = localMinIdx + 1;
        while (rightIdx < scores.length && scores[rightIdx] > scores[rightIdx - 1]) {
            rewards[rightIdx] = rewards[rightIdx - 1] + 1;
            rightIdx++;
        }
    }

    private static List<Integer> getLocalMinIdx(int[] scores) {
        List<Integer> result = new ArrayList<>();

        if (scores.length == 1) {
            result.add(0);
            return result;
        }

        for (int i = 0; i < scores.length; i++) {
            if (i == 0 && scores[i] < scores[i + 1]) {
                result.add(i);
            }
            if (i == scores.length - 1 && scores[i] < scores[i - 1]) {
                result.add(i);
            }
            if (i == 0 || i == scores.length - 1) {
                continue;
            }
            if (scores[i] < scores[i+1] && scores[i] < scores[i-1]) {
                result.add(i);
            }
        }
        return result;
    }

    public static int minRewardsLocal3(int[] scores) {
        int[] resArray = new int[scores.length];
        resArray[0] = 1;
        for (int i = 1; i < scores.length; i++) {
            resArray[i] = 1;
            if (scores[i] > scores[i - 1]) {
                resArray[i] = resArray[i - 1] + 1;
            }
        }

        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                resArray[i] = Math.max(resArray[i], resArray[i+1] + 1);
            }
        }

        int sum = 0;
        for (int element : resArray) {
            sum += element;
        }
        return sum;
    }


}
