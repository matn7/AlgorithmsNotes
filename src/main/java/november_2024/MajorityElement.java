package november_2024;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        MajorityElement majorityElement = new MajorityElement();
        int result = majorityElement.majorityElement(nums);
        System.out.println(result);
    }

//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> count = new HashMap<>();
//        int max = 0;
//        int maxNum = 0;
//        for (int n : nums) {
//            count.put(n, count.getOrDefault(n, 0) + 1);
//            if (count.get(n) > max) {
//                maxNum = n;
//                max = count.get(n);
//            }
//        }
//        return maxNum;
//    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }

}
