package july_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayWithTargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7, 2};
        List<Integer> numsArr = new ArrayList<>();
        for (int n : nums) {
            numsArr.add(n);
        }
        int k = 14;

        List<Integer> result = findContinuousK(numsArr, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> findContinuousK(List<Integer> list, int k) {
        Map<Integer, Integer> previousSum = new HashMap<>();
        previousSum.put(0, -1);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            sum += n;
            previousSum.put(sum, i);
            if (previousSum.containsKey(sum - k)) {
                return list.subList(previousSum.get(sum - k) + 1, i + 1);
            }
        }
        return null;
    }

}
