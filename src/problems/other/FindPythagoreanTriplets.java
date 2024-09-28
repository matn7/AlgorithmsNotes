package problems.other;

import java.util.HashSet;
import java.util.Set;

public class FindPythagoreanTriplets {

    public static void main(String[] args) {
        int[] nums = {3, 5, 12, 5, 13};

        FindPythagoreanTriplets find = new FindPythagoreanTriplets();
        boolean result = find.findPythagoreanTriplets(nums);
        System.out.println();
    }

    // O(n^2) time | O(n) space
    public boolean findPythagoreanTriplets(int[] nums) {
        Set<Integer> squares = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] * nums[i];
            squares.add(val);
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

    // O(n^3) time | O(1) space
    public boolean findPythagoreanTriplets2(int[] nums) {

        for (int a = 0; a < nums.length; a++) {
            for (int b = 0; b < nums.length; b++) {
                for (int c = 0; c < nums.length; c++) {
                    if (a*a + b*b == c*c) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    
}
