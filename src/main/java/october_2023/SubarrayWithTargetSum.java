package october_2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayWithTargetSum {

    public static void main(String[] args) {
        int[] num = {1, 3, 2, 5, 7, 2};
        int k = 14;
        List<Integer> nums = new ArrayList<>();
        for (int n : num) {
            nums.add(n);
        }

        List<Integer> result = subarray(nums, k);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static List<Integer> subarray(List<Integer> nums, int k) {
        if (nums.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(nums);
        int sum = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < nums.size()) {
            if (sum == k) {
                return result.subList(startIdx, endIdx);
            }
            if (sum < k) {
                sum += nums.get(endIdx);
                endIdx++;
            } else {
                sum -= nums.get(startIdx);
                startIdx++;
            }
        }

        return null;
    }

    // O(n) time | O(n) space
    public static List<Integer> subarray2(List<Integer> nums, int k) {
        if (nums.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(nums);
        Map<Integer, Integer> sumsMap = new HashMap<>();
        sumsMap.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            int key = sum - k;
            if (sumsMap.containsKey(key)) {
                System.out.println();
                int beginIdx = sumsMap.get(key) + 1;
                int endIdx = i + 1;
                return result.subList(beginIdx, endIdx);
            }
            sumsMap.put(sum, i);
        }

        return null;
    }

    // O(n^2) time | O(n) space
    public static List<Integer> subarray3(List<Integer> nums, int k) {
        if (nums.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(nums);
        for (int i = 0; i < nums.size(); i++) {
            int sum = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                sum += nums.get(j);
                if (sum == k) {
                    return result.subList(i, j + 1);
                }
            }
        }

        return null;
    }

}
