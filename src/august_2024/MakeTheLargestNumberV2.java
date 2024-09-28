package august_2024;

import java.util.ArrayList;
import java.util.List;

public class MakeTheLargestNumberV2 {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72, 781};

        String result = makeLargestNumber(nums);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public static String makeLargestNumber(int[] nums) {
        List<String> input = new ArrayList<>();
        for (int num : nums) {
            input.add(String.valueOf(num));
        }

        input.sort((a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        StringBuilder builder = new StringBuilder();
        for (String str : input) {
            builder.append(str);
        }
        return builder.toString();
    }

}
