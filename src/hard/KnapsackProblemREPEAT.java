package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblemREPEAT {

    public static void main(String[] args) {
        int[][] items = {{1,2},{4,3},{5,6},{6,7}};
        int capacity = 10;

        knapsackProblem(items, capacity);
    }

    // O(n * c) time (c capacity) | O(n * c) space
    // OK - repeated 05/02/2022
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        //          0   1   2   3   4   5   6   7   8   9   10
        //  ---------------------------------------------------
        //  []      0   0   0   0   0   0   0   0   0   0   0
        //  [1,2]   0   0   1   1   1   1   1   1   1   1   1
        //  [4,3]   0   0   1   4   4   5   5   5   5   5   5
        //  [5,6]   0   0   1   4   4   5   5   5   6   9   9
        //  [6,7]   0   0   1   4   4   5   5   6   6   9   10

        for (int i = 1; i < items.length + 1; i++) { // 3
            int currentWeight = items[i - 1][1]; // 7
            int currentValue = items[i - 1][0];  // 6
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) {
                    knapsackValues[i][c] = knapsackValues[i - 1][c];
                } else {
                    knapsackValues[i][c] = Math.max(knapsackValues[i - 1][c],
                            knapsackValues[i - 1][c - currentWeight] + currentValue);
                }
            }
        }
        int finalValue = knapsackValues[items.length][capacity]; // 10
        List<Integer> knapsackItems = getKnapSackItems(knapsackValues, items);
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(finalValue));
        result.add(knapsackItems);
        return result;
    }

    //          0   1   2   3   4   5   6   7   8   9   10
    //  ---------------------------------------------------
    //  []      0   0   0   0   0   0   0   0   0   0   0
    //  [1,2]   0   0   1   1   1   1   1   1   1   1   1
    //  [4,3]   0   0   1   4   4   5   5   5   5   5   5
    //  [5,6]   0   0   1   4*  4   5   5   5   6   9   9
    //  [6,7]   0   0   1   4   4   5   5   6   6   9   10*
    private static List<Integer> getKnapSackItems(int[][] knapsackValues, int[][] items) {
        // [[1,2],[4,3],[5,6],[6,7]]
        List<Integer> sequence = new ArrayList<>();
        int i = knapsackValues.length - 1;      // 1
        int c = knapsackValues[0].length - 1;   // 0
        while (i > 0) {
            if (knapsackValues[i][c] == knapsackValues[i - 1][c]) { // 10 == 9
                i--;
            } else {
                sequence.add(i - 1); // [3,1]
                c -= items[i - 1][1]; // items[1][1] = 3
                i--;
            }
            if (c == 0) {
                break;
            }
        }
        Collections.reverse(sequence); // [3, 1]   ---> [[4,3], [6,7]]
        return sequence; // [1,3], means items at index 1 and 3
    }

}
