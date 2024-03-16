package coderpro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayWithTargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7, 2};
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        int target = 14;

        SubarrayWithTargetSum subarrayWithTargetSum = new SubarrayWithTargetSum();
        List<Integer> result = subarrayWithTargetSum.find_continuous_k(list, target);
        System.out.println();
    }

    // O(n) time | O(n) space
    public List<Integer> find_continuous_k(List<Integer> list, int k) {
        Map<Integer, Integer> previous_sums = new HashMap<>();
        previous_sums.put(0, -1);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            sum += n;
            previous_sums.put(sum, i);
            if (previous_sums.containsKey(sum - k)) {
                return list.subList(previous_sums.get(sum - k) + 1, i + 1);
            }
        }
        return null;
    }

    // O(n^2) time | O(1) space
    public List<Integer> find_continuous_k2(List<Integer> list, int k) {
        for (int start = 0; start < list.size(); start++) {
            int sum = 0;
            for (int end = start; end < list.size(); end++) {
                sum += list.get(end);
                if (sum == k) {
                    System.out.println();
                    return list.subList(start, end + 1);
                }
            }
        }
        return null;
    }

    // O(n) time | O(n) space
    public List<Integer> find_continuous_k3(List<Integer> list, int target) {
        int start = 0;
        int end = 0;
        int sum = 0;

        //              e
        // [1, 3, 2, 5, 7, 2], 14
        //        s
        while (end < list.size()) {
            int curr = list.get(end); // 7
            if (sum + curr == target) {
                break;
            } else if (sum + curr < target) {
                sum += curr; // 7
                end++;
            } else {
                sum -= list.get(start);
                start++;
            }
        }
        return list.subList(start, end + 1);
    }


}
