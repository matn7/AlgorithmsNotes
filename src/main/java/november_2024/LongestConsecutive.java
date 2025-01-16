package november_2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {2,20,4,10,3,4,5};
//        int[] nums = {100,4,200,1,3,2};

        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int result = longestConsecutive.longestConsecutive(nums);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num : nums) {
            elements.add(num);
        }

        int max = 0;
        for (int num : nums) {
            if (!elements.contains(num)) {
                continue;
            }
            elements.remove(num);
            int size = 1;
            int toLeft = num - 1;
            while (elements.contains(toLeft)) {
                size++;
                elements.remove(toLeft);
                toLeft--;
            }

            int toRight = num + 1;
            while (elements.contains(toRight)) {
                size++;
                elements.remove(toRight);
                toRight++;
            }
            max = Math.max(max, size);
        }

        return max;
    }

}
