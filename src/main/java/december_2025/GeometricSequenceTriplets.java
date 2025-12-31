package december_2025;

import java.util.HashMap;
import java.util.Map;

public class GeometricSequenceTriplets {

    public static void main(String[] args) {
        int[] nums2 = {2, 1, 2, 4, 8, 8};
        int r2 = 2;

        GeometricSequenceTriplets geometricSequenceTriplets = new GeometricSequenceTriplets();
        int result = geometricSequenceTriplets.geometricSequenceTriplets(nums2, r2);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int geometricSequenceTriplets(int[] nums, int r) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }

        System.out.println();

        int count = 0;
        for (int num : nums) {
            rightMap.put(num, rightMap.get(num) - 1);

            if (num % r == 0) {
                count += leftMap.getOrDefault(num / r, 0) * rightMap.getOrDefault(num * r, 0);
            }

            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
            System.out.println();
        }

        return count;
    }

}
