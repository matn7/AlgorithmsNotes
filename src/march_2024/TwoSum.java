package march_2024;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 6, 12, 14};
        int target = 15;

        int[] result = twoSum(nums, target);
        System.out.println(result);

        int[] result2 = twoSum2(nums, target);
        System.out.println(result2);
    }

    // O(n) time | O(n) space
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (sumMap.containsKey(key)) {
                Integer index = sumMap.get(key);
                result[0] = index;
                result[1] = i;
                break;
            } else {
                sumMap.put(num, i);
            }
        }
        return result;
    }

    // O(n) time | O(n) space
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int reminder = target - nums[i];
            if (map.containsKey(nums[i])) {
                Integer valueToFindIdx = map.get(nums[i]);
                return new int[] {valueToFindIdx, i};
            }
            map.put(reminder, i);
        }
        return new int[] {-1, -1};
    }


}




















