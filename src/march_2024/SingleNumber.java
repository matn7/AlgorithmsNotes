package march_2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 4};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    // O(n) time | O(1) space
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int n : nums) {
            single ^= n;
        }
        return single;
    }

    // O(n) time | O(n) space
    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer uniqueSum = set.stream().reduce(0, Integer::sum);
        int sum = Arrays.stream(nums).reduce(0, Integer::sum);

        return 2 * uniqueSum - sum;
    }

}
