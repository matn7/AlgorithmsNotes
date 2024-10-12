package may_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeLargestNumber {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72, 781};

        String result = largestNumber(nums);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public static String largestNumber(int[] nums) {
        List<String> numsArr = new ArrayList<>();
        for (int num : nums) {
            numsArr.add(String.valueOf(num));
        }

        numsArr.sort((a, b) -> {
            String strA = a + "" + b;
            String strB = b + "" + a;
            return strB.compareTo(strA);
        });

        StringBuilder builder = new StringBuilder();
        for (String str : numsArr) {
            builder.append(str);
        }

        return builder.toString();
    }

}
