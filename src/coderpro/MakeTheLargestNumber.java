package coderpro;

import java.util.*;

public class MakeTheLargestNumber {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72};

        MakeTheLargestNumber makeTheLargestNumber = new MakeTheLargestNumber();
        makeTheLargestNumber.largestNum(nums);
    }

    // O(nlog(n)) time | O(n) space
    public String largestNum(int[] nums) {

        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = "" + nums[i];
        }

        Arrays.sort(numsStr, (a, b) -> {
            String comp1 = a + b;
            String comp2 = b + a;
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
