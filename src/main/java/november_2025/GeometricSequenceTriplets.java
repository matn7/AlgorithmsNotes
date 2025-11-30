package november_2025;

import java.util.*;

public class GeometricSequenceTriplets {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int[] n1 = {2, 1, 2, 4, 8, 8};

        for (int n : n1) {
            nums.add(n);
        }

        int r = 2;

        GeometricSequenceTriplets geometricSequenceTriplets = new GeometricSequenceTriplets();
        int result = geometricSequenceTriplets.geometric_sequence_triplets(nums, r);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int geometric_sequence_triplets(ArrayList<Integer> nums, int r) {
        // Write your code here

        HashMap<Long, Long> leftMap = new HashMap<>();
        HashMap<Long, Long> rightMap = new HashMap<>();
        long count = 0;

        for (int num : nums) {
            long x = num;
            rightMap.put(x, rightMap.getOrDefault(x, 0L) + 1);
        }

        for (int num : nums) {
            long x = num;
            rightMap.put(x, rightMap.get(x) - 1);
            if (x % r == 0) {
                count += leftMap.getOrDefault(x / r, 0L) * rightMap.getOrDefault(x * r, 0L);
            }
            leftMap.put(x, leftMap.getOrDefault(x, 0L) + 1);
        }

        return (int) count;
    }

}
