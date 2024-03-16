package january_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithTargetSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 2};
        List<Integer> array = new ArrayList<>();
        for (int n : arr) {
            array.add(n);
        }
        int target = 14;

        List<Integer> integers = subArrayWithTargetSum(array, target);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static List<Integer> subArrayWithTargetSum(List<Integer> array, int k) {
        Map<Integer, Integer> previousSums = new HashMap<>();
        previousSums.put(0, -1);
        int sum = 0;

        for (int index = 0; index < array.size(); index++) {
            int n = array.get(index);
            sum += n;
            previousSums.put(sum, index);
            if (previousSums.containsKey(sum - k)) {
                return array.subList(previousSums.get(sum - k) + 1, index + 1);
            }
        }

        return null;
    }


}
