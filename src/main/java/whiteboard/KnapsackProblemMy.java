package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblemMy {

    public static void main(String[] args) {
        int[][] items = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int capacity = 10;

        knapsackProblem(items, capacity);
    }

    // O(nc) time (c capacity) | O(nc) space
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        // Replace the code below.
        int[][] values = new int[items.length + 1][capacity + 1];
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 1; row < values.length; row++) {
            int[] current = items[row - 1];
            int val = current[0];
            int cap = current[1];
            for (int col = 1; col < values[row].length; col++) {
                if (col >= cap) {
                    values[row][col] = Math.max(val + values[row - 1][col - cap], values[row - 1][col]);
                } else {
                    values[row][col] = Math.max(values[row - 1][col], values[row][col - 1]);
                }
            }
        }

        int totalValue = values[items.length][capacity];
        result.add(Arrays.asList(totalValue));
        List<Integer> sequence = buildSequence(values, items);
        Collections.reverse(sequence);
        result.add(sequence);

        return result;
    }

    private static List<Integer> buildSequence(int[][] values, int[][] items) {
        List<Integer> sequence = new ArrayList<>();
        int r = values.length - 1;
        int c = values[r].length - 1;

        while (r > 0 && c > 0) {
            if (values[r][c] != values[r-1][c]) {
                sequence.add(r - 1);
                c = c - items[r - 1][1];
                r -= 1;
            } else {
                r -= 1;
            }
        }

        return sequence;
    }

}
