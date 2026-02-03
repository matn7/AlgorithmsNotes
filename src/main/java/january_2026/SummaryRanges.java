package january_2026;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,4,5,7};

//        int[] nums = {0,2,3,4,6,8,9};

        int[] nums = {-2147483648,0,2,3,4,6,8,9};

        SummaryRanges summaryRanges = new SummaryRanges();
        List<String> strings = summaryRanges.summaryRanges(nums);
        System.out.println(strings);
    }

    // O(n) time | O(1) space
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int s = nums[0];
        int p = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n == p || n == p + 1) {
                p++;
            } else {
                if (s == p) {
                    result.add(s + "");
                }  else {
                    result.add(s + "->" + p);
                }
                s = n;
                p = n;
            }
        }
        if (s == p) {
            result.add(s + "");
        }  else {
            result.add(s + "->" + p);
        }
        return result;
    }

}
