package coderpro;

import java.util.*;

public class MakeTheLargestNumber {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72};

        MakeTheLargestNumber makeTheLargestNumber = new MakeTheLargestNumber();
        makeTheLargestNumber.largestNum(nums);
    }

    // ********
    // * STAR *
    // ********

    // Custom sorting !!!

    // O(nlog(n)) time | O(n) space - O(log(n)) for quick sort on avg case, but in worst case O(n^2)
    public String largestNum(int[] nums) {

        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = "" + nums[i];
        }

        Arrays.sort(numsStr, (a, b) -> {
            String comp1 = a + b; // 772 - compare 7 with 72
            String comp2 = b + a; // 727 - compare 72 with 7
            // means 7 comes before 72
            return comp2.compareTo(comp1);
        });

        StringBuilder builder = new StringBuilder();
        for (String num : numsStr) {
            builder.append(num);
        }

        String string = builder.toString();
        return string;
    }


}
