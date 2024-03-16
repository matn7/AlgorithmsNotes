package october_2023;

import java.util.ArrayList;
import java.util.List;

public class MakeTheLargestNumber {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72, 781};
        System.out.println(largestNumber(nums));
    }

    // O(nlog(n)) time | O(n) space
    public static String largestNumber(int[] nums) {
        List<String> strNums = new ArrayList<>();
        for (int n : nums) {
            strNums.add(String.valueOf(n));
        }

        strNums.sort((a,b) -> {
            String comp1 = a + b;
            String comp2 = b + a;
            return comp2.compareTo(comp1);
        });

        StringBuilder builder = new StringBuilder();
        for (String word : strNums) {
            builder.append(word);
        }

        return builder.toString();
    }

}
