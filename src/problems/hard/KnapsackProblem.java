package problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[][] items = {{1,2},{4,3},{5,6},{6,7}};
        int capacity = 10;

        knapsackProblem(items, capacity);
    }

    // O(n * c) time (c capacity) | O(n * c) space
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
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
        int finalValue = knapsackValues[items.length][capacity];
        List<Integer> knapsackItems = getKnapSackItems(knapsackValues, items);
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(finalValue));
        result.add(knapsackItems);
        return result;
    }

    private static List<Integer> getKnapSackItems(int[][] knapsackValues, int[][] items) {
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
        Collections.reverse(sequence);
        return sequence;
    }

}
