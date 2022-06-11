package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinRewardsREPEAT {

    public static void main(String[] args) {
        int[] scores = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        //             [4, 3, 2, 1, 2, 3, 4, 5, 1]
        int result = minRewards(scores);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    // OK - repeated 03/02/2022
    public static int minRewards(int[] scores) {
        if (scores.length == 1) {
            return scores[0];
        }
        int[] rewards = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            rewards[i] = 1;
        }

        //                   i1 i
        // sores = [8, 4, 2, 1, 3, 6, 7, 9, 5]
        // rewards=[1, 1, 1, 1, 2, 3, 4, 5, 1]
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) { // 5 > 9
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        //          i  i1
        // sores = [8, 4, 2, 1, 3, 6, 7, 9, 5]
        // rewards=[4, 3, 2, 1, 2, 3, 4, 5, 1]
        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) { // 8 > 4
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1); // max(1, 4)
            }
        }
        int sum = 0;
        for (int element : rewards) {
            sum += element;
        }
        return sum;
    }

//    // O(n) time | O(n) space
//    public static int minRewards(int[] scores) {
//        // Write your code here.
//        if (scores.length == 1) {
//            return scores[0];
//        }
//        int[] rewards = new int[scores.length];
//        for (int i = 0; i < scores.length; i++) {
//            rewards[i] = 1;
//        }
//        List<Integer> localMinIdxs = getLocalMinIdxs(scores);
//        for (int localMinIdx : localMinIdxs) {
//            expandFromLocalMinIdx(localMinIdx, scores, rewards);
//        }
//        int sum = 0;
//        for (int element : rewards) {
//            sum += element;
//        }
//        return sum;
//    }
//
//    private static void expandFromLocalMinIdx(int localMinIdx, int[] scores, int[] rewards) {
//        int leftIdx = localMinIdx - 1;
//        while (leftIdx >= 0 && scores[leftIdx] > scores[leftIdx + 1]) {
//            rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx + 1] + 1);
//            leftIdx--;
//        }
//        int rightIdx = localMinIdx + 1;
//        while (rightIdx < scores.length && scores[rightIdx] > scores[rightIdx - 1]) {
//            rewards[rightIdx] = rewards[rightIdx - 1] + 1;
//            rightIdx++;
//        }
//    }
//
//    private static List<Integer> getLocalMinIdxs(int[] array) {
//        if (array.length == 1) {
//            return new ArrayList<>(Arrays.asList(array[0]));
//        }
//        List<Integer> localMinIdxs = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (i == 0 && array[i] < array[i + 1]) {
//                localMinIdxs.add(i);
//            }
//            if (i == array.length - 1 && array[i] < array[i - 1]) {
//                localMinIdxs.add(i);
//            }
//            if (i == 0 || i == array.length - 1) {
//                continue;
//            }
//            if (array[i] < array[i - 1] && array[i] < array[i - 1]) {
//                localMinIdxs.add(i);
//            }
//        }
//        return localMinIdxs;
//    }

//    // O(n^2) time | O(n) space
//    public static int minRewards(int[] scores) {
//        // Write your code here.
//        int[] rewards = new int[scores.length];
//        for (int i = 0; i < scores.length; i++) {
//            rewards[i] = 1;
//        }
//        for (int i = 1; i < scores.length; i++) {
//            int j = i - 1;
//            if (scores[i] > scores[j]) {
//                rewards[i] = rewards[j] + 1;
//            } else {
//                while (j >= 0 && scores[j] > scores[j + 1]) {
//                    rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
//                    j--;
//                }
//            }
//        }
//        int sum = 0;
//        for (int element : rewards) {
//            sum += element;
//        }
//        return sum;
//    }

}
