package star;

import java.util.ArrayList;
import java.util.List;

public class MakeTheLargestNumber {

    public static void main(String[] args) {
        int[] nums = {17, 7, 2, 45, 72, 781};

        MakeTheLargestNumber makeTheLargestNumber = new MakeTheLargestNumber();
        makeTheLargestNumber.largestNumber(nums);
    }

    // O(nlog(n)) time | O(n) space
    public String largestNumber(int[] nums) {
        List<String> strs = new ArrayList<>();
        for (int num : nums) {
            strs.add(String.valueOf(num));
        }

//        strs.sort((a, b) -> {
//            String one = String.valueOf(a.charAt(0));
//            String two = String.valueOf(b.charAt(0));
//            if (Integer.parseInt(one) > Integer.parseInt(two)) {
//                return -1;
//            } else if (Integer.parseInt(one) < Integer.parseInt(two)) {
//                return 1;
//            }
//            return 0;
//        });

        strs.sort((a, b) -> {
            String comp1 = a + b;
            String comp2 = b + a;
            return comp2.compareTo(comp1);
        });

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }

        String string = builder.toString();
        return string;
    }

}
