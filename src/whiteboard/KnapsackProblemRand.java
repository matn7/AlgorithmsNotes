package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblemRand {

    public static void main(String[] args) {
        int[][] items = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int capacity = 10;

        knapsackProblem(items, capacity);
    }

    // O(h * w) time | O(h * w) space
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        // Replace the code below.
        int[][] values = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < values.length; i++) {
            int[] currentItem = items[i - 1];   // [1, 2]
            int currentValue = currentItem[0];
            int currentWeight = currentItem[1];
            for (int c = 1; c < values[i].length; c++) {
                if (c < currentWeight) {
                    values[i][c] = Math.max(values[i][c - 1], values[i - 1][c]);
                } else {
                    values[i][c] = Math.max(currentValue + values[i - 1][c - currentWeight], values[i - 1][c]);
                }
            }
        }

        int maxCapacity = values[values.length - 1][capacity];

        List<Integer> totalValue = Arrays.asList(maxCapacity);
        List<Integer> finalItems = buildSequence(items, values);
        var result = new ArrayList<List<Integer>>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }

    private static List<Integer> buildSequence(int[][] items, int[][] values) {
        List<Integer> finalItems = new ArrayList<>();
        int c = values[0].length - 1;
        int i = values.length - 1;
        while (i > 0 && c > 0) {
            if (values[i][c] != values[i - 1][c]) {
                finalItems.add(i - 1);
                int[] item = items[i - 1];
                c -= item[1];
                i--;
            } else {
                i--;
            }
        }

        return finalItems;
    }

}
