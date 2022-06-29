package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[][] items = {{1,2}, {4,3}, {5,6}, {6,7}};

        knapsackProblem(items, 10);
    }

    // O(nc) time | O(nc) space
    // #2: 23/06/2022
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        // Replace the code below.
        int[][] maxes = new int[items.length + 1][capacity + 1];
        int[][] newItems = new int[items.length + 1][2];
        newItems[0][0] = 0;
        newItems[0][1] = 0;
        for (int i = 1; i <= items.length; i++) {
            newItems[i][0] = items[i - 1][0];
            newItems[i][1] = items[i - 1][1];
        }

        for (int i = 1; i < newItems.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int[] currentItem = newItems[i];
                int currentValue = currentItem[0];
                int currentWeight = currentItem[1];
                if (currentWeight > c) {
                    maxes[i][c] = Math.max(maxes[i][c-1], maxes[i-1][c]);
                } else {
                    maxes[i][c] = Math.max(currentValue,
                            Math.max(currentValue + maxes[i-1][c-currentWeight], maxes[i-1][c]));
                }

            }

        }

        int maxValue = maxes[items.length][capacity];

        List<Integer> totalValue = Arrays.asList(maxValue);

        List<Integer> finalItems = new ArrayList<>();

        buildSequence(maxes, items, finalItems);
        Collections.reverse(finalItems);

        var result = new ArrayList<List<Integer>>();
        result.add(totalValue);
        result.add(finalItems);
        return result;
    }

    private static void buildSequence(int[][] maxes, int[][] newItems, List<Integer> finalItems) {
        int idx = maxes.length - 1;
        int c = maxes[0].length - 1;

        while (idx > 0) {
            if (maxes[idx][c] == maxes[idx-1][c]) {
                idx--;
            } else {
                finalItems.add(idx - 1);
                c -= newItems[idx-1][1];
                idx--;
            }
            if (c == 0) {
                break;
            }
        }
    }

}
