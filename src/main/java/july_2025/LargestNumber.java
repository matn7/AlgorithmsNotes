package july_2025;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LargestNumber largestNumber = new LargestNumber();
        String result = largestNumber.largestNumber(nums);
        System.out.println(result);
    }

    // Intuition:
    // - sorting
    // Approach:
    // - change num to str
    // - add sorting way: (a + b).compareTo(b + a)
    // - corner cases - how to sort ["0","0"]
    // Complexity:
    // - O(nlog(n)) time | O(n) space
    // Code:

    // [3, 5, 9, 30, 34]
    // [34, 30, 9, 5, 3]
    // [9]
    // [3, 30] - 330 > 303

    public String largestNumber(int[] nums) {
        List<String> numsArr = new ArrayList<>();
        for (int num : nums) {
            numsArr.add(String.valueOf(num));
        }
        numsArr.sort((a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        if (numsArr.get(0).equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String s : numsArr) {
            result.append(s);
        }
        return result.toString();
    }

}
