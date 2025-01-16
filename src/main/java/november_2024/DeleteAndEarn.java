package november_2024;

import java.util.*;

public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 5, 6, 6};
//        int[] nums = {3, 4, 2};

        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int result = deleteAndEarn.deleteAndEarn(nums);
        System.out.println(result);
    }

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> sets = new HashSet<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            sets.add(n);
        }

        List<Integer> numsArr = new ArrayList<>(sets);
        numsArr.sort(Comparator.comparingInt(a -> a));

        int[] dp = new int[numsArr.size() + 1];
        for (int i = 1; i <= numsArr.size(); i++) {
            int num = numsArr.get(i - 1); // 3
            int prevNum = num - 1; // 1
            int sum = num * count.get(num); // 2 * 1
            if (i > 1 && numsArr.get(i - 2) != prevNum) {
                sum += dp[i - 1];
            } else if (i > 2) {
                sum += dp[i - 2];
            }
            dp[i] = sum;
        }

        return dp[dp.length - 1];
    }

}
