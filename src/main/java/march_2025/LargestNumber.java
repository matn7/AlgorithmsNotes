package march_2025;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72, 781};

        LargestNumber largestNumber = new LargestNumber();
        String result = largestNumber.largestNumber(nums);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public String largestNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int num : nums) {
            strs.add(String.valueOf(num));
        }

        strs.sort((a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }

        if (builder.charAt(0) == '0') {
            return "0";
        }

        return builder.toString();
    }

}
