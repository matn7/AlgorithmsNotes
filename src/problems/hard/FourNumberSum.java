package problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {

    public static void main(String[] args) {
        int[] array = {7, 6, 4, -1, 1, 2};

        List<Integer[]> integers = fourNumberSum(array, 16);

        for (Integer[] element : integers) {
            for (Integer elem : element) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    // Average: O(n^2) time | O(n^2) space
    // Worst: O(n^3) time | O(n^2)
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if (allPairSums.containsKey(difference)) {
                    for (Integer[] pair : allPairSums.get(difference)) {
                        Integer[] result = new Integer[] {pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(result);
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int currentSum = array[i] + array[k];
                if (!allPairSums.containsKey(currentSum)) {
                    List<Integer[]> resultArray = new ArrayList<>();
                    resultArray.add(new Integer[] {array[k], array[i]});
                    allPairSums.put(currentSum, resultArray);
                } else {
                    List<Integer[]> temp = allPairSums.get(currentSum);
                    allPairSums.remove(currentSum);
                    temp.add(new Integer[] {array[k], array[i]});
                    allPairSums.put(currentSum, temp);
                }
            }
        }

        return quadruplets;
    }

}
