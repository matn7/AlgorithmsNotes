package january_2026;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {


    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};

        LargestNumber largestNumber = new LargestNumber();
        String result = largestNumber.largestNumber(nums);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        List<String> strs = new ArrayList<>();
        for (int num : nums) {
            strs.add(String.valueOf(num));
        }

        strs.sort((a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        if (strs.get(0).equals("0")) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

}
