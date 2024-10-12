package december_2023;

import java.util.HashSet;
import java.util.Set;

public class FindPythagoreanTriplets {

    public static void main(String[] args) {
        int[] nums = {3, 5, 12, 5, 13};

        boolean result = findPythagoreanTriplets(nums);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static boolean findPythagoreanTriplets(int[] nums) {
        Set<Integer> squares = new HashSet<>();
        for (int num : nums) {
            squares.add(num * num);
        }

        for (int a : nums) {
            for (int b : nums) {
                if (squares.contains(a*a + b*b)) {
                    return true;
                }
            }
        }
        return false;
    }

}
