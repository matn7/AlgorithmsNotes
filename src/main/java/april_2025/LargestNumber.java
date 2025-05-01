package april_2025;

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
        int sum = 0;
        List<String> numsArr = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            numsArr.add(String.valueOf(num));
        }
        if (sum == 0) {
            return "0";
        }

        numsArr.sort((a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });

        StringBuilder builder = new StringBuilder();
        for (String num : numsArr) {
            builder.append(num);
        }
        return builder.toString();
    }

}
