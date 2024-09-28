package august_2024;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MakeTheLargestNumber {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72, 781};

        // 78177245217
        // 78177245217

        String result = makeLargestNum(nums);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public static String makeLargestNum(int[] nums) {
        List<String> strArr = new ArrayList<>();
        for (int num : nums) {
            strArr.add(String.valueOf(num));
        }

        strArr.sort((a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        StringBuilder builder = new StringBuilder();
        for (String s : strArr) {
            builder.append(s);
        }

        return builder.toString();
    }

}
