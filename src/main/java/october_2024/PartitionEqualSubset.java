package october_2024;

import java.util.*;

public class PartitionEqualSubset {

    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5};
//        int[] nums = {2, 2, 1, 1};

        PartitionEqualSubset partitionEqualSubset = new PartitionEqualSubset();
        boolean result = partitionEqualSubset.canPartition(nums);
        System.out.println(result);
    }

    // O(n*sum(nums)) time
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        List<Integer> set = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        seen.add(0);
        set.add(0);

        int half = sum / 2;
        for (int n : nums) {
            int size = set.size();
            for (int i = 0; i < size; i++) {
                int curr = set.get(i);
                int newSum = curr + n;
                if (newSum == half) {
                    return true;
                }
                if (!seen.contains(newSum)) {
                    set.add(newSum);
                    seen.add(newSum);
                }
            }
        }

        return false;
    }




}
