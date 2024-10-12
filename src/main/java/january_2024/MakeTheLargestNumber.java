package january_2024;

import java.util.Arrays;
import java.util.Comparator;

public class MakeTheLargestNumber {

    public static void main(String[] args) {
        String[] nums = {"17", "7", "2", "45", "72"};
        largestNum(nums);
    }

    // O(nlog(n)) time | O(n) space - O(log(n)) for quick sort on avg case, but in worst case O(n^2)
    public static String largestNum(String[] nums) {


        Arrays.sort(nums, (a, b) -> {
            String comp1 = a + b; // 772 - compare 7 with 72
            String comp2 = b + a; // 727 - compare 72 with 7
            // means 7 comes before 72
            return comp2.compareTo(comp1);
        });

        StringBuilder builder = new StringBuilder();
        for (String num : nums) {
            builder.append(num);
        }

        String string = builder.toString();
        return string;
    }

}
