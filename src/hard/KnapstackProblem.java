package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapstackProblem {

    public static void main(String[] args) {
        int[][] items = {{1,2},{4,3},{5,6},{6,7}};
        int capacity = 10;

        knapsackProblem(items, capacity);
    }

    // O(nc) time (c capacity) | O(nc) space
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        // Replace the code below.
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < items.length + 1; i++) {
            int currentWeight = items[i - 1][1];
            int currentValue = items[i - 1][0];
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) {
                    knapsackValues[i][c] = knapsackValues[i - 1][c];
                } else {
                    knapsackValues[i][c] = Math.max(knapsackValues[i - 1][c],
                            knapsackValues[i - 1][c - currentWeight] + currentValue);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        res1.add(knapsackValues[items.length][capacity]);
        List<Integer> res2 = getKnapsackItems(knapsackValues, items);
        result.add(res1);
        result.add(res2);
        return result;
    }

    private static List<Integer> getKnapsackItems(int[][] knapsackValues, int[][] items) {
        List<Integer> sequence = new ArrayList<>();
        int i = knapsackValues.length - 1;
        int c = knapsackValues[0].length - 1;
        while (i > 0) {
            if (knapsackValues[i][c] == knapsackValues[i - 1][c]) {
                i--;
            } else {
                sequence.add(i - 1);
                c -= items[i - 1][1];
                i--;
            }
            if (c == 0) {
                break;
            }
        }
        return sequence;
    }
}
