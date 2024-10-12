package october_2023;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[][] items = {{1,2}, {4,3}, {5,6}, {6,7}};
        int capacity = 10;

        knapsackProblem(items, capacity);
    }

    // O(n*m) time | O(n*m) space
    public static List<int[]> knapsackProblem(int[][] items, int capacity) {

        // [value, weight]
        //
        //          0   1   2   3   4   5   6   7   8   9   10
        // -----------------------------------------------------
        // []       0   0   0   0   0   0   0   0   0   0   0
        // [1,2]    0   0   1   1   1   1   1   1   1   1   1
        // [4,3]    0   0   1   4   4   5   5   5   5   5   5
        // [5,6]    0   0   1   4   4   5   5   5   6   9   9
        // [6,7]    0   0   1   4   4   5   5   6   6   9   10

        int[][] values = new int[items.length + 1][capacity + 1];
        for (int row = 0; row < values.length; row++) {
            values[row][0] = 0;
        }
        for (int col = 0; col <= capacity; col++) {
            values[0][col] = 0;
        }
        for (int row = 1; row < values.length; row++) {
            int[] item = items[row - 1];    // [1,2] [value, capacity]
            int value = item[0];
            int cap = item[1];
            for (int col = 1; col <= capacity; col++) {
                if (col >= cap) {
                    values[row][col] = Math.max(values[row - 1][col], value + values[row-1][col - cap]); // (6, 9)
                } else {
                    values[row][col] = Math.max(values[row][col - 1], Math.max(values[row - 1][col - 1], values[row - 1][col]));
                }
            }
        }

        int maxValue = values[items.length][capacity];
        List<Integer> val = new ArrayList<>();
        val.add(maxValue);
        List<int[]> sequence = buildSequence(values, items);
        return sequence;
    }

    private static List<int[]> buildSequence(int[][] values, int[][] items) {
        List<int[]> sequence = new ArrayList<>();
        int row = values.length - 1;
        int col = values[0].length - 1;

        while (row > 0 && col > 0) {
            if (values[row][col] != values[row-1][col]) { // 10 != 9
                sequence.add(items[row - 1]);
                int cap = items[row - 1][1];
                col -= cap;
                row--;
            } else {
                row--;
            }
        }

        return sequence;
    }

}
