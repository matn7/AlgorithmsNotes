package october_2023;

import java.util.HashMap;
import java.util.Map;

public class NonDuplicateNum {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 3, 2};

        int result = nonDuplicate(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int nonDuplicate(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }

    // O(n) time | O(n) space
    public static int nonDuplicate2(int[] nums) {
        Map<Integer, Integer> countsMap = new HashMap<>();

        for (int num : nums) {
            if (countsMap.containsKey(num)) {
                countsMap.put(num, countsMap.get(num) + 1);
            } else {
                countsMap.put(num, 1);
            }
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> element : countsMap.entrySet()) {
            Integer key = element.getKey();
            Integer value = element.getValue();
            if (value == 1) {
                return key;
            }
        }

        return result;
    }

}
