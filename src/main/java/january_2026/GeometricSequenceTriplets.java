package january_2026;

import java.util.HashMap;
import java.util.Map;

public class GeometricSequenceTriplets {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 8, 8};
        int r = 2;

        GeometricSequenceTriplets geometricSequenceTriplets = new GeometricSequenceTriplets();
        int result = geometricSequenceTriplets.geometricSequenceTriplets(nums, r);
        System.out.println(result);
    }

    public int geometricSequenceTriplets(int[] nums, int r) {
        int count = 0;

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            rightMap.put(num, rightMap.get(num) - 1);
            if (num % r == 0) {
                count += leftMap.getOrDefault(num / r, 0) * rightMap.getOrDefault(num * r, 0);
            }
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }

}
