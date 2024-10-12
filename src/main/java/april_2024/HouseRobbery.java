package april_2024;

import java.util.HashMap;
import java.util.Map;

public class HouseRobbery {

    public static void main(String[] args) {
        int[] nums = {6, 5, 5, 9, 3};

        int result = houseRobbery(nums);
        System.out.println(result);

        int result2 = houseRobberyRec(nums);
        System.out.println(result2);

        int result3 = houseRobberyRec2(nums);
        System.out.println(result3);

        int result4 = houseRobbery2(nums);
        System.out.println(result4);
    }

    // O(n) time | O(n) space
    public static int houseRobbery(int[] nums) {

        int[] amount = new int[nums.length];
        amount[0] = nums[0];
        amount[1] = Math.max(nums[0], nums[1]);

        // [1, 5, 0, 0]

        for (int i = 2; i < nums.length; i++) {
            amount[i] = Math.max(amount[i - 1], nums[i] + amount[i - 2]);
        }

        return amount[nums.length - 1];
    }

    // O(n) time | O(1) space
    public static int houseRobbery2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int house1 = nums[0];
        int house2 = Math.max(nums[0], nums[1]);
        int ans = house2;

        for (int i = 2; i < nums.length; i++) {
            ans = Math.max(nums[i] + house1, house2);
            house1 = house2;
            house2 = ans;
        }

        return ans;
    }

    // O(2^n) time | O(2^n) space -> either take it or not take it for every element
    public static int houseRobberyRec(int[] house) {
        return houseRobberyRecHelper(house, house.length - 1);
    }

    private static int houseRobberyRecHelper(int[] house, int index) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return house[0];
        }
        if (index == 1) {
            return Math.max(house[0], house[1]);
        }
        return Math.max(house[index] + houseRobberyRecHelper(house, index - 2),
                houseRobberyRecHelper(house, index - 1));
    }

    // O(n) time | O(n) space
    public static int houseRobberyRec2(int[] house) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, house[0]);
        memo.put(1, Math.max(house[0], house[1]));
        return houseRobberyRecHelper2(house, house.length - 1, memo);
    }

    private static int houseRobberyRecHelper2(int[] house, int index, Map<Integer, Integer> memo) {
        if (index < 0) {
            return 0;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        memo.put(index, Math.max(house[index] + houseRobberyRecHelper2(house, index - 2, memo),
                houseRobberyRecHelper2(house, index - 1, memo)));
        return memo.get(index);
    }


}
