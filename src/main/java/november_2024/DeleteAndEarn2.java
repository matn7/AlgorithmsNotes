package november_2024;

import java.util.*;

public class DeleteAndEarn2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 5, 6, 6};
//        int[] nums = {3, 4, 2};

        DeleteAndEarn2 deleteAndEarn = new DeleteAndEarn2();
        int result = deleteAndEarn.deleteAndEarn(nums);
        System.out.println(result);
    }

    // ********
    // * STAR *
    // ********

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> sets = new HashSet<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            sets.add(n);
        }

        List<Integer> numsArr = new ArrayList<>(sets);
        numsArr.sort(Comparator.comparingInt(a -> a));

        int earn1 = 0;
        int earn2 = 0;

        for (int i = 0; i < numsArr.size(); i++) {
            int curEarn = numsArr.get(i) * count.get(numsArr.get(i));
            // can't use both curEarn and earn
            if (i > 0 && numsArr.get(i) == numsArr.get(i - 1) + 1) {
                int temp = earn2;
                earn2 = Math.max(curEarn + earn1, earn2);
                earn1 = temp;
            } else {
                int temp = earn2;
                earn2 = curEarn + earn2;
                earn1 = temp;
            }
        }

        return earn2;
    }

}
